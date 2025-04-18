package conf

import (
	"log/slog"
	"os"
)

func SetupLogger() {
	slog.SetDefault(slog.New(slog.NewTextHandler(os.Stdout, nil)))

}
