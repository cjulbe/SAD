# Server
from flask import Flask, jsonify
from flask_socketio import SocketIO, emit
import requests
import datetime as dt 

app = Flask(__name__)
app.config['SECRET_KEY'] = 'esunsecret1234'
socketio = SocketIO(app)

@app.route('/')
def index():
    return jsonify({'message': 'Hello, world!'})

@socketio.on('get_weather')
def get_weather(data):
    
    BASE_URL= "http://api.openweathermap.org/data/2.5/weather?"
    API_KEY= "f1b1af4594b289ef32467e44f61e0830"
    city = data['city']
    url= BASE_URL + "appid=" + API_KEY + "&q=" + city
    
    response= requests.get(url).json()
    data = {
    'temp_kelvin': response['main']['temp'],
    'temp_celsius': kelvin_to_celsius_fahrenheit(response['main']['temp'])[0],
    'temp_fahrenheit': kelvin_to_celsius_fahrenheit(response['main']['temp'])[1],
    'feels_like_kelvin': response['main']['feels_like'],
    'feels_like_celsius': kelvin_to_celsius_fahrenheit(response['main']['feels_like'])[0],
    'feels_like_fahrenheit': kelvin_to_celsius_fahrenheit(response['main']['feels_like'])[1],
    'wind_speed': response['wind']['speed'],
    'humidity': response['main']['humidity'],
    'description': response['weather'][0]['description'],
    'sunrise_time': str(dt.datetime.utcfromtimestamp(response['sys']['sunrise'] + response['timezone'])),
    'sunset_time': str(dt.datetime.utcfromtimestamp(response['sys']['sunset'] + response['timezone']))
    }
    emit('weather_data', data)

    
def kelvin_to_celsius_fahrenheit(kelvin):
    celsius= kelvin - 273.15
    fahrenheit = celsius * (9/5) + 32
    return celsius, fahrenheit



if __name__ == '__main__':
    socketio.run(app)
