package conf

import (
	"net/http"

	"github.com/gorilla/mux"
	"github.com/lucas-10101/sales-app/conf/middlewares"
	"github.com/lucas-10101/sales-app/controllers"
)

func GetDeclaredRoutes() *mux.Router {

	router := mux.NewRouter()

	router.Use(middlewares.ContentTypeAwareMiddleware)

	sellersSubRoutes := router.PathPrefix("/sellers").Subrouter()
	sellersSubRoutes.Methods(http.MethodGet).HandlerFunc(controllers.NewSeller)

	return router
}
