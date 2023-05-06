from website import create_app

app= create_app()

if __name__== '__main__':
    app.run(debug=True) #run our flask application, and rerun if there's any changes

