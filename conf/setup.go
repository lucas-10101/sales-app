package conf

import (
	"log/slog"
	"os"
)

func SetupLogger() {

	options := &slog.HandlerOptions{
		Level: slog.LevelDebug,
	}

	slog.SetDefault(slog.New(slog.NewTextHandler(os.Stdout, options)))

}
