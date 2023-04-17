#   Frontend UI Application

This application is a React "frontend" application that consumes an HTTP/JSON API.

It happens to be built with [Vite](https://vitejs.dev/), but it doesn't really matter.

##  Build

    npm install
    npm run build

##  Run Locally

    npm run preview

##  Explore the UI

    http://127.0.0.1:4173/

##  Build Image

    pack build frontend --buildpack paketo-buildpacks/web-servers \
                          --env BP_NODE_RUN_SCRIPTS=build \
                          --env BP_WEB_SERVER=nginx \
                          --env BP_WEB_SERVER_ROOT=dist

##  Run Image

    docker run --env PORT=4173 -p 4173:4173 frontend