package admin

import (
	"bytes"
	"fmt"
	"net/http"
	"encoding/json"

	"cms/content"
	"cms/management/manager"
	"cms/management/editor"
	"cms/system/db"
	"strings"
)

const (
	// ErrTypeNotRegistered means content type isn't registered (not found in content.Types map)
	ErrTypeNotRegistered = `Error:
There is no type registered for %[1]s

Add this to the file which defines %[1]s{} in the 'content' package:
--------------------------------+

func init() {
	Types["%[1]s"] = %[1]s{}
}

--------------------------------+
`
)

func init() {
	http.HandleFunc("/admin", func(res http.ResponseWriter, req *http.Request) {
		adminView := Admin(nil)
		res.Header().Set("Cotent-Type", "text/html")
		res.Write(adminView)
	})

	http.HandleFunc("/admin/posts", func(res http.ResponseWriter, req *http.Request) {
		q := req.URL.Query()
		t := q.Get("type")
		if t == "" {
			res.WriteHeader(http.StatusBadRequest)
		}

		posts := db.GetAll(t)
		b := &bytes.Buffer{}
		p := content.Types[t]().(editor.Editable)

		html := `<a href="/admin/edit?type=` + t + `" class="button">New ` + t + `</a>
			<ul class="posts">`

		for i := range posts {
			json.Unmarshal(posts[i], &p)
			post := `<li><a href="/admin/edit?type=` +
				t + `&id=` + fmt.Sprintf("%d", p.ContentID()) +
				`">` + p.ContentName() + `</a></li>`
			b.Write([]byte(post))
		}

		html += b.String()

		adminView := Admin([]byte(html))

		res.Header().Set("Content-Type", "text/html")
		res.Write(adminView)
	})
	http.HandleFunc("/admin/edit", func(res http.ResponseWriter, req *http.Request) {
		err := req.ParseForm()
		if err != nil {
			res.WriteHeader(http.StatusBadRequest)
			return
		}
		switch req.Method {
		case http.MethodGet:
			q := req.URL.Query()
			i := q.Get("id")
			t := q.Get("type")
			contentType, ok := content.Types[t]
			if !ok {
				fmt.Fprintf(res, content.ErrTypeNotRegistered, t)
				return
			}
			post := contentType()

			if i != "" {
				data, err := db.Get(t + ":" + i)
				if err != nil {
					fmt.Println(err)
					res.WriteHeader(http.StatusInternalServerError)
					return
				}

				err = json.Unmarshal(data, post)
				if err != nil {
					fmt.Println(err)
					res.WriteHeader(http.StatusInternalServerError)
					return
				}

			} else {
				post.(editor.Editable).SetContentID(-1)
			}

			m, err := manager.Manage(post.(editor.Editable), t)
			adminView := Admin(m)
			if err != nil {
				fmt.Println(err)
				res.WriteHeader(http.StatusInternalServerError)
				return
			}
			res.Header().Set("Content-Type", "text/html")
			res.Write(adminView)
		case http.MethodPost:
			cid := req.FormValue("id")
			t := req.FormValue("type")

			var discardKeys []string
			for k, v := range req.PostForm {
				if strings.Contains(k, ".") {
					key := strings.Split(k, ".")[0]

					if req.PostForm.Get(key) == "" {
						req.PostForm.Set(key, v[0])
						discardKeys = append(discardKeys, k)
					} else {
						req.PostForm.Add(key, v[0])
					}
				}
			}

			for _, discardKey := range discardKeys {
				req.PostForm.Del(discardKey)
			}

			id, err := db.Set(t+":"+cid, req.PostForm)
			if err != nil {
				fmt.Println(err)
				res.WriteHeader(http.StatusInternalServerError)
				return
			}

			scheme := req.URL.Scheme
			host := req.URL.Host
			path := req.URL.Path
			sid := fmt.Sprintf("%d", id)
			desURL := scheme + host + path + "?type=" + t + "&id=" + sid
			http.Redirect(res, req, desURL, http.StatusFound)
		}
	})
}
