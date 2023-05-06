
from website import db

from flask_login import UserMixin #custom class for flask login
from sqlalchemy.sql import func

#Database models
class Note(db.Model):
    id = db.Column(db.Integer, primary_key=True)
    data = db.Column(db.String(10000))
    date = db.Column(db.DateTime(timezone=True), default=func.now())
    user_id = db.Column(db.Integer, db.ForeignKey('user.id')) #ForeignKey: a column refers to a column of another database

class User(db.Model, UserMixin):
    id = db.Column(db.Integer, primary_key= True) #primary key unique to represent the data
    email = db.Column(db.String(150), unique=True) #no user can have the same e-mail as another user; one to many relationship
    password = db.Column(db.String(150))
    first_name= db.Column(db.String(150))
    notes = db.relationship('Note') #list that stores all the different notes, we can access the notes a user has been written