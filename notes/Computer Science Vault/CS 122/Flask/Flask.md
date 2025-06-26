Web framework
Requires a virtual environment VE
`from flask import Flask`
- Need to `pip install flask`
## Virtual Environment
Isolated space for python projects
- Like building a house
`python -m venv my_virtual_environment_name`
### Files
`lib`: subfolder with **python versions** and **site packages**
### Activation
MacOS: `source my_virtual_environment_name/bin/activate`
Windows :`.\my_virtual_environment_name\Scripts\activate.bat`
## Creating a Program (Web Application)
```
from flask import Flask

app = Flask(__name__)


@app.route('/')
def hello():
    return 'Hello, World!'
```
### Running
`$ export FLASK_APP=app`
- Where `app` is the `app.py` or the another file name
`$ flask run` to **run application**
- Default port is `5000`, can change with `flask run -p XXXX`
## Templates (HTML)
uses `render_template` from:
- `from flask import Flask, render_template`
```
from flask import Flask, render_template

app = Flask(__name__)

@app.route('/')
def index():
    return render_template('index.html')
```
- Will use `index.html` in the `templates` subdirectory
Will compile during runtime
## Static Files
Files that live in the `static` subdirectory
- Used for:
1. css
2. javaScript
### Accessing Files
To grab these files in code, uses `url_for`
#### `url_for('static', filename=directoryPath)`
- `directoryPath` is a string for the path
Remember to use `"{{ ... }}"` to run code in HTML