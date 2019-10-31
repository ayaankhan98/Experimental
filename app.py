from flask import Flask, render_template

app = Flask(__name__)

@app.route('/')
def index():
   return render_template("index.html")

@app.route('/projects')
def projects():
    return("<h1>Under Process</h1>")
