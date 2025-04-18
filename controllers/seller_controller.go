package controllers

import "net/http"

func NewSeller(writter http.ResponseWriter, request *http.Request) {
	writter.Write([]byte("ok"))
}
