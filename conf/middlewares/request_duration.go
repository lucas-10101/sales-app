package middlewares

import (
	"fmt"
	"log/slog"
	"net/http"
	"time"
)

func RequestDurationAware(next http.Handler) http.Handler {
	return http.HandlerFunc(func(w http.ResponseWriter, r *http.Request) {

		start := time.Now()
		defer func(start time.Time) {
			err := recover()
			end := time.Now()

			slog.Debug(fmt.Sprintf("request took %f seconds to complete", end.Sub(start).Seconds()))

			if err != nil {
				panic(err)
			}

		}(start)

		next.ServeHTTP(w, r)

	})
}
