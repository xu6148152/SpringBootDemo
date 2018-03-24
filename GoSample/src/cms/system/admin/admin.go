package admin

import (
	"bytes"
	"html/template"

	"cms/content"
	"fmt"
)

const adminHTML = `<!doctype html>
<html>
    <head>
        <title>CMS</title>
        <style type="text/css">
            form {
                display: block;
                margin-top: 11px 0;
            }
			label {}
            input, textarea, select {
                display: block;
                margin: 11px 0 22px 0;
                padding: 2px;
            }
			input[type=checkbox] {
				dispaly: inline-block;
				margin-left: 11px;
			}
        </style>
    </head>
    <body>
        <h1><a href="/admin">CMS</a></h1>
        <div class="types">
            <ul>
            {{ range $t, $f := .Types }}
                <li><a href="/admin/posts?type={{ $t }}">{{ $t }}</a></li>
            {{ end }}
            </ul>
        </div>
        {{ if .Subview}}
        <div class="manager">
            {{ .Subview }}
        </div>
        {{ end }}
    </body>
</html>`

type admin struct {
	Types   map[string]func() interface{}
	Subview template.HTML
}

func Admin(manager []byte) []byte {
	a := admin{
		Types:   content.Types,
		Subview: template.HTML(manager),
	}
	fmt.Println(a.Types)
	buf := &bytes.Buffer{}
	tmpl := template.Must(template.New("admin").Parse(adminHTML))
	tmpl.Execute(buf, a)

	return buf.Bytes()
}
