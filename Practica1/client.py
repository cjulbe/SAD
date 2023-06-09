
# Client
from socketIO_client import SocketIO

def weather_results(data):
    temp_celsius = data['temp_celsius']
    temp_fahrenheit = data['temp_fahrenheit']
    feels_like_celsius = data['feels_like_celsius']
    feels_like_fahrenheit = data['feels_like_fahrenheit']
    humidity = data['humidity']
    wind_speed = data['wind_speed']
    description = data['description']
    sunrise_time = data['sunrise_time']
    sunset_time = data['sunset_time']
    sunrise_time = data['sunrise_time']

    print(f"Temperature in {city}: {temp_celsius:.2f}ºC or {temp_fahrenheit:.2f}ºF")
    print(f"Temperature in {city} feels like: {feels_like_celsius:.2f}ºC or {feels_like_fahrenheit:.2f}ºF")
    print(f"Humidity in {city}: {humidity}%")
    print(f"Wind Speed in {city}: {wind_speed}m/s")
    print(f"General Weather in {city}: {description}")
    print(f"Sun rises in {city}: {sunrise_time} local time.")
    print(f"Sun sets in {city}: {sunset_time} local time.") 

with SocketIO('localhost', 5000) as socket:
    city = input('Enter a city name: ')
    socket.emit('get_weather', {'city': city})
    socket.on('weather_data', on_weather_data)
    socket.wait()
