package conf

import (
	"database/sql"
	"log/slog"
	"os"

	_ "github.com/lib/pq"
)

var dbConnection *sql.DB

func GetConnection() *sql.DB {

	if dbConnection != nil {
		return dbConnection
	}

	connectionString := os.Getenv("RDS_SALESAPP_CONNECTION_STRING")

	connection, err := sql.Open("postgres", connectionString)

	if err != nil {
		slog.Error(err.Error())
		panic(err.Error())
	}

	dbConnection = connection

	return dbConnection

}
