package controllers

import (
	"encoding/json"
	"log/slog"
	"net/http"

	"github.com/lucas-10101/sales-app/models"
)

func NewSeller(writter http.ResponseWriter, request *http.Request) {

	decoder := json.NewDecoder(request.Body)
	decoder.DisallowUnknownFields()

	seller := &models.Seller{}
	if err := decoder.Decode(seller); err != nil {
		slog.Error(err.Error())
		writter.WriteHeader(http.StatusBadRequest)
		return
	}
}
