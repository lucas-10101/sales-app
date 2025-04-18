package conf

import (
	"net/http"
)

func StartServer() {
	http.ListenAndServe("127.0.0.1:8080", GetDeclaredRoutes())
}
