package conf

import (
	"log/slog"
	"net/http"
)

func StartServer() {
	if err := http.ListenAndServe("127.0.0.1:8080", GetDeclaredRoutes()); err != nil {
		slog.Error(err.Error())
		panic(err.Error())
	}
}
