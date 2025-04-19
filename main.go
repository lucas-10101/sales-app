package main

import (
	"fmt"
	"log/slog"

	"github.com/lucas-10101/sales-app/conf"
)

func main() {

	defer func() {
		if err := recover(); err != nil {
			slog.Error("panic cause: " + fmt.Sprintf("%v", err))
		}
	}()

	var id int
	var name string
	result, err := conf.GetConnection().Query("SELECT id, texto FROM TESTE")

	if err != nil {
		slog.Error(err.Error())
	}

	for result.Next() {
		result.Scan(&id, &name)

		fmt.Printf("Id is: %d, name: %s\n", id, name)
	}

	conf.SetupLogger()
	//conf.StartServer()
}
