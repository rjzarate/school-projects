import sqlite3

connection = sqlite3.connect('database.db')


with open('schema.sql') as f:
    connection.executescript(f.read())

cur = connection.cursor()

# Insert categories
cur.execute("INSERT INTO Categories (category_name) VALUES (?)", ("Electronics",))
cur.execute("INSERT INTO Categories (category_name) VALUES (?)", ("Clothing",))

# Get foreign keys
cur.execute("SELECT category_id FROM Categories WHERE category_name = ?", ("Electronics",))
electronics_id = cur.fetchone()[0]
cur.execute("SELECT category_id FROM Categories WHERE category_name = ?", ("Clothing",))
clothing_id = cur.fetchone()[0]

# Insert products
cur.execute("INSERT INTO Products (product_name, category_id) VALUES (?, ?)", ("Laptop", electronics_id))
cur.execute("INSERT INTO Products (product_name, category_id) VALUES (?, ?)", ("T-shirt", clothing_id))

connection.commit()
connection.close()
