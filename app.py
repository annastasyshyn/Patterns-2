import time
from flask import Flask

app = Flask("__main__")

@app.route("/")
def index():
    time.sleep(1000)
    return "hello"

if __name__ == '__main__':
    app.run()