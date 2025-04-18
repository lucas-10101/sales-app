package middlewares

import (
	"log/slog"
	"net/http"

	"github.com/lucas-10101/sales-app/conf/headers"
)

func ContentTypeAwareMiddleware(next http.Handler) http.Handler {
	return http.HandlerFunc(func(writter http.ResponseWriter, request *http.Request) {
		switch request.Header.Get(headers.CONTENT_TYPE) {
		case headers.APPLICATION_JSON:
			next.ServeHTTP(writter, request)
		case "":
			fallthrough
		default:
			writter.WriteHeader(http.StatusUnsupportedMediaType)
			slog.Debug("blocked by ContentTypeAwareMiddleware")
		}
	})
}
