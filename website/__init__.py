from flask import Flask
from flask_sqlalchemy import SQLAlchemy
from os import path

db = SQLAlchemy()
DB_NAME="database.db"

def create_app():
    app = Flask(__name__)
    app.config['SECRET_KEY'] = 'hjshjhdjah kjshkjdhjs'
    app.config['SQLALCHEMY_DATABASE_URI'] = f'sqlite:///{DB_NAME}'

    db.init_app(app)

    from .views import views
    from .auth import auth

    app.register_blueprint(views, url_prefix='/') 
    app.register_blueprint(auth, url_prefix='/')

    #Check if they are loaded before we inicialize or create the database
    from .models import User, Note
    create_database(app) #This app has the URI of where to set up the database

    return app



def create_database(app):
    if not path.exists('website/' + DB_NAME): #Whether or not the path to our database exists
        db.create_all(app=app)
        print('Created Database!')
