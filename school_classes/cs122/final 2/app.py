import sqlite3
from flask import Flask, render_template, request, url_for, flash, redirect

app = Flask(__name__)
app.config['SECRET_KEY'] = 'froilan'

def get_db_connection():
    conn = sqlite3.connect('database.db')
    conn.row_factory = sqlite3.Row
    return conn

# Main page
@app.route('/')
def index():
    conn = get_db_connection()

    # Get categories and products from table
    categories = conn.execute('SELECT * FROM Categories').fetchall()
    products = conn.execute(
        'SELECT Products.product_id, Products.product_name, Categories.category_name '
        'FROM Products '
        'LEFT JOIN Categories ON Products.category_id = Categories.category_id'
    ).fetchall()
    conn.close()

    return render_template('index.html', categories=categories, products=products)

# Adding category page
@app.route('/add-category', methods=('GET', 'POST'))
def add_category():
    if request.method == 'POST':
        category_name = request.form['category_name']

        # Edge case: no category name
        if not category_name:
            render_template('add_category.html')

        # Connect to db and add category
        connection = get_db_connection()
        connection.execute('INSERT INTO Categories (category_name) VALUES (?)', (category_name,))
        connection.commit()
        connection.close()

        return redirect(url_for('index'))

    return render_template('add_category.html')

# Adding product page
@app.route('/add-product', methods=('GET', 'POST'))
def add_product():
    # Connect to db to access categories
    conn = get_db_connection()
    categories = conn.execute('SELECT * FROM Categories').fetchall()
    
    if request.method == 'POST':
        product_name = request.form['product_name']
        category_id = request.form['category_id']

        # Edge case: no product or category picked
        if not product_name or not category_id:
            conn.close()
            return render_template('add_product.html', categories=categories)
        
        # Push new product
        conn.execute(
            'INSERT INTO Products (product_name, category_id) VALUES (?, ?)',
            (product_name, category_id)
        )
        conn.commit()
        conn.close()
        flash('Product added successfully!')
        return redirect(url_for('index'))
    
    conn.close()
    return render_template('add_product.html', categories=categories)