from flask import Blueprint, render_template

#Define that this file is the Blueprint of our application, has different routes inside
views = Blueprint('views',__name__) #Set up a Blueprint for our Flask application

@views.route('/') #When we call this route it will call the home function
def home():
    return render_template("home.html")

