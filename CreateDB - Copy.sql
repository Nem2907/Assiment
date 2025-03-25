CREATE DATABASE Assigment
USE Assigment
DROP DATABASE Assigment
-- Customers Table

-- Categories Table
CREATE TABLE Categories (
    CategoryID VARCHAR(10) PRIMARY KEY,
    CategoryName VARCHAR(255) NOT NULL,
    Description VARCHAR(500)
);

-- Suppliers Table
CREATE TABLE Suppliers (
    SupplierID VARCHAR(10) PRIMARY KEY,
    CompanyName VARCHAR(255) NOT NULL,
    Address VARCHAR(500),
    Phone VARCHAR(15)
);

-- Products Table
CREATE TABLE Products (
    ProductID int PRIMARY KEY IDENTITY(1,1),
    ProductName VARCHAR(255) NOT NULL,
    SupplierID VARCHAR(10),
    CategoryID VARCHAR(10),
    QuantityPerUnit int,
    UnitPrice DECIMAL(10,2),
	Description VARCHAR(500),
    ProductImage TEXT, --link url
	Sale INT NOT NULL DEFAULT 1, -- 1 = Sale, 0 = Not Sale (Mặc định là User)
    CONSTRAINT CK_Products_Sale CHECK (Sale IN (0, 1)), -- Ràng buộc giá trị Type
    FOREIGN KEY (SupplierID) REFERENCES Suppliers(SupplierID),
    FOREIGN KEY (CategoryID) REFERENCES Categories(CategoryID)
);

-- Orders Table
DROP TABLE Orders
CREATE TABLE Orders(
	OrderID varchar(10) PRIMARY KEY,
	AccountID int,
	OrderDate DATE,
	RequiredDate DATE DEFAULT GETDATE(),
	ShippedDate DATE,
	Freight DECIMAL(10,2),
	ShipAddress VARCHAR(500),
	FOREIGN KEY (AccountID) REFERENCES Account(AccountID)
)

-- Order Details Table
CREATE TABLE OrderDetails (
    OrderID varchar(10),
    ProductID int,
    UnitPrice DECIMAL(10,2),
    Quantity INT,
    PRIMARY KEY (OrderID, ProductID),
    FOREIGN KEY (OrderID) REFERENCES Orders(OrderID),
    FOREIGN KEY (ProductID) REFERENCES Products(ProductID)
);

-- Account Table
CREATE TABLE Account (
    AccountID INT PRIMARY key IDENTITY(1,1),
    UserName VARCHAR(255) NOT NULL UNIQUE,
    Password VARCHAR(255) NOT NULL,
	FullName NVARCHAR(255),
	PhoneNumber VARCHAR(15),
    Email VARCHAR(50), 
    Role VARCHAR(10) NOT NULL DEFAULT 'user', -- Mặc định là 'user'
    CONSTRAINT CK_Account_Role CHECK (Role IN ('user', 'admin')) -- Ràng buộc giá trị hợp lệ
);
-- Insert into Account
INSERT INTO Account (UserName, Password, FullName, PhoneNumber, Email, Role) VALUES
('admin', 'admin123', N'Administrator','1122334455','example@gmail.com', 'admin'), 
('john_doe', 'password123', N'John Doe', '0987654321','user123@yahoo.com','user'),
('jane_smith', 'jane456', N'Jane Smith','1234567890','contact@domain.com', 'user'),
('peter_parker', 'spiderman', N'Peter Parker','0977687321','admin@company.org', 'user'),
('nem', '123456789', N'Nguyễn Hoàng Nem','0706364866','hoangnamlongho@gmail.com', 'admin')
-- Cart:
DROP TABLE Cart
CREATE TABLE Cart (
    CartID INT PRIMARY KEY IDENTITY(1,1),  -- ID tự động tăng để xác định từng giỏ hàng
    AccountID INT NOT NULL,  -- Liên kết với tài khoản người dùng
    ProductID INT NOT NULL,  -- Sản phẩm được thêm vào giỏ hàng
    Quantity INT NOT NULL CHECK (Quantity > 0),  -- Số lượng sản phẩm, không được âm hoặc 0
    AddedDate DATETIME DEFAULT GETDATE(),  -- Ngày thêm vào giỏ hàng
    FOREIGN KEY (AccountID) REFERENCES Account(AccountID),  -- Ràng buộc với tài khoản
    FOREIGN KEY (ProductID) REFERENCES Products(ProductID)  -- Ràng buộc với sản phẩm
);

--Insert Cart:
INSERT INTO Cart (AccountID, ProductID, Quantity) VALUES
(2, 1, 2),  -- John Doe thêm 2 cái Margherita Pizza vào giỏ hàng
(2, 5, 1),  -- John Doe thêm 1 lon Coca Cola vào giỏ hàng
(3, 2, 1),  -- Jane Smith thêm 1 cái Pepperoni Pizza vào giỏ hàng
(3, 6, 2),  -- Jane Smith thêm 2 lon Sprite vào giỏ hàng
(4, 3, 1);


-- Insert into Categories
INSERT INTO Categories (CategoryID, CategoryName, Description) VALUES
('CAT01', 'Cheese Pizza', 'Classic cheese pizza with mozzarella and tomato sauce'),
('CAT02', 'Pepperoni Pizza', 'Topped with spicy pepperoni slices'),
('CAT03', 'Veggie Pizza', 'Loaded with fresh vegetables'),
('CAT04', 'BBQ Chicken Pizza', 'BBQ sauce, grilled chicken, and onions');


-- Insert into Suppliers
INSERT INTO Suppliers (SupplierID, CompanyName, Address, Phone) VALUES
('S001', 'Fresh Pizza Ingredients Ltd.', '100 Food St, NY', '9876543210'),
('S002', 'Cheese & More', '200 Dairy Ave, CA', '6543210987'),
('S003', 'Meat Lovers Supply', '300 Meat Blvd, TX', '3210987654');

-- Insert into Products
INSERT INTO Products (ProductName, SupplierID, CategoryID, QuantityPerUnit, UnitPrice, Description, ProductImage, Sale) VALUES
-- Cheese & Classic Pizzas
('Margherita Pizza', 'S001', 'CAT01', 10, 9.99, 'Classic Margherita pizza with mozzarella, tomato sauce, and basil', 'https://media.istockphoto.com/id/1396086301/vi/anh/pizza-v%E1%BB%9Bi-c%C3%A0-chua-ph%C3%B4-mai-n%E1%BA%A5m-v%C3%A0-th%E1%BA%A3o-m%E1%BB%99c-t%C6%B0%C6%A1i-%C4%91%C6%B0%E1%BB%A3c-c%C3%A1ch-ly-tr%C3%AAn-n%E1%BB%81n-tr%E1%BA%AFng.jpg?s=2048x2048&w=is&k=20&c=f_aSpS7IflVMqG33IL8iphVoRYP50siKvB0dtpxP6b8=', 1),
('Four Cheese Pizza', 'S002', 'CAT01', 12, 11.99, 'Blend of mozzarella, cheddar, parmesan, and blue cheese', 'https://kitchenatics.com/wp-content/uploads/2020/09/Cheese-pizza-1.jpg', 1),
('White Pizza', 'S001', 'CAT01', 8, 10.99, 'Ricotta cheese, garlic, olive oil, and mozzarella', 'https://theveglife.com/wp-content/uploads/2014/02/white-pizza.jpg', 1),
-- Meat & Specialty Pizzas
('Pepperoni Pizza', 'S002', 'CAT02', 15, 12.99, 'Crispy pepperoni on melted cheese and tomato sauce', 'https://www.perfectitaliano.com.au/content/dam/perfectitaliano-aus/recipe/pepperoni_pizza_standard.jpg', 1),
('BBQ Chicken Pizza', 'S003', 'CAT04', 10, 13.99, 'Grilled chicken with smoky BBQ sauce and onions', 'https://food.fnr.sndimg.com/content/dam/images/food/fullset/2012/2/28/1/FNM_040112-Copy-That-002_s4x3.jpg.rend.hgtvcom.826.620.suffix/1382541346030.webp', 1),
('Meat Lovers Pizza', 'S003', 'CAT02', 12, 14.99, 'Pepperoni, sausage, ham, bacon, and beef', 'https://www.perfectitaliano.com.au/content/dam/perfectitaliano-aus/recipe/0_desktop/Desktop-MeatLovers-Pizza.jpg.transform/image1220/image.jpg', 1),
('Buffalo Chicken Pizza', 'S003', 'CAT04', 9, 13.49, 'Spicy buffalo sauce with grilled chicken and ranch drizzle', 'https://hips.hearstapps.com/hmg-prod/images/190226-buffalo-chicken-pizza-370-1552084943.jpg?crop=0.668xw:1.00xh;0.209xw,0.00255xh&resize=1200:*', 1),
-- Veggie & Gourmet Pizzas
('Veggie Supreme Pizza', 'S001', 'CAT03', 12, 11.99, 'Mushrooms, bell peppers, onions, and olives', 'https://www.nordicware.com/wp-content/uploads/2021/05/46400_traditional_pizza_pan_02_e.jpg', 1),
('Greek Pizza', 'S002', 'CAT03', 8, 12.49, 'Feta cheese, black olives, tomatoes, and red onions', 'https://jimcooksfoodgood.com/wp-content/uploads/2022/12/NEw-ENgland-Greek-pizza-840x473.jpg', 1),
('Mushroom Truffle Pizza', 'S001', 'CAT03', 7, 15.99, 'Mushroom, truffle oil, and parmesan cheese', 'https://metirementblog.com/wp-content/uploads/2017/10/Wild-Mushroom-and-Truffle-Pizza-2.jpg', 1),
-- Seafood Pizzas
('Shrimp Scampi Pizza', 'S003', 'CAT04', 6, 16.99, 'Garlic shrimp, olive oil, and mozzarella', 'https://cookwhatyoulove.com/wp-content/uploads/2021/05/shrimp-scampi-small.webp', 1),
('Tuna & Onion Pizza', 'S002', 'CAT04', 7, 13.99, 'Tuna chunks, red onions, and mozzarella', 'https://www.homecookingadventure.com/wp-content/uploads/2022/01/tuna-and-red-onion-pizza.jpg', 1),
('Salmon & Cream Cheese Pizza', 'S003', 'CAT04', 5, 18.49, 'Smoked salmon, cream cheese, and arugula', 'https://cdn.shopify.com/s/files/1/0274/9503/9079/files/fishy-lemony-pizza_319d9b9e-fc6c-4373-9e66-04039c062d4a.jpg?v=1723659766?w=1024', 1),
-- Unique & Experimental Pizzas
('Hawaiian Pizza', 'S002', 'CAT02', 14, 12.49, 'Ham, pineapple, and mozzarella', 'https://www.kingarthurbaking.com/sites/default/files/styles/featured_image_2x/public/2020-03/hawaiian-pizza.jpg?itok=4JxPVaHa', 1),
('Taco Pizza', 'S003', 'CAT02', 10, 14.49, 'Ground beef, cheddar cheese, lettuce, and salsa', 'https://www.cookingmamas.com/wp-content/uploads/2012/03/Taco-Pizza.jpg', 1),
('Mac & Cheese Pizza', 'S001', 'CAT01', 9, 13.99, 'Macaroni and cheese on a pizza crust', 'https://hipfoodiemom.com/wp-content/uploads/2014/04/Macaroni-and-Cheese-Pizza_closeup-HipFoodieMom.com_-600x400-1-500x400.jpg', 1),
('Carbonara Pizza', 'S002', 'CAT04', 7, 15.49, 'Bacon, parmesan, and creamy white sauce', 'https://hips.hearstapps.com/hmg-prod/images/carbonara-pizza-index-66eaefd019fa2.jpg?crop=0.6664313448641016xw:1xh;center,top&resize=1200:*', 1),
-- Spicy & International Pizzas
('Spicy Chorizo Pizza', 'S003', 'CAT02', 6, 14.99, 'Chorizo sausage, jalapenos, and hot sauce', 'https://www.perfectitaliano.com.au/content/dam/perfectitaliano-aus/recipe/0_desktop/Desktop-Spanish-Chorizo-Capsicum-Olive-Pizza.jpg.transform/image1220/image.jpg', 1),
('Indian Tandoori Pizza', 'S001', 'CAT04', 5, 16.49, 'Tandoori chicken, cilantro, and yogurt sauce', 'https://img.taste.com.au/a5UGmqme/w720-h480-cfill-q80/taste/2016/11/tandoori-chicken-pizza-60718-1.jpeg', 1),
('Kimchi Bulgogi Pizza', 'S002', 'CAT04', 5, 17.49, 'Korean bulgogi beef with kimchi', 'https://koreancuisinerecipes.com/wp-content/uploads/2021/02/bulgogi-kimchi-pizza.png', 1),
--to add
('Pesto Chicken Pizza', 'S002', 'CAT03', 8, 14.99, 'Grilled chicken with basil pesto sauce and cherry tomatoes', 'https://foxeslovelemons.com/wp-content/uploads/2024/07/Pesto-Chicken-Pizza-Foxes-Love-Lemons.jpg', 1),
('BBQ Pulled Pork Pizza', 'S003', 'CAT02', 6, 15.99, 'Slow-cooked pulled pork with BBQ sauce and red onions', 'https://yelskitchen.com/wp-content/uploads/2024/02/pizza-1.jpg', 1),
('Gorgonzola Pear Pizza', 'S001', 'CAT03', 5, 16.99, 'Gorgonzola cheese with sliced pears and walnuts', 'https://threebigbites.com/wp-content/uploads/2020/04/FoodPizzaBlueCheesePear.jpg', 1);


-- Insert into Orders
INSERT INTO Orders (OrderID, AccountID, OrderDate, RequiredDate, ShippedDate, Freight, ShipAddress) VALUES
('O001', 2, '2025-03-01', '2025-03-03', '2025-03-02', 5.99, '123 Main St, New York'),
('O002', 3, '2025-03-02', '2025-03-04', '2025-03-03', 7.99, '456 Maple Ave, LA'),
('O003', 4, '2025-03-03', '2025-03-05', NULL, 6.50, 'Queens, New York');



-- Insert into OrderDetails
INSERT INTO OrderDetails (OrderID, ProductID, UnitPrice, Quantity) VALUES
('O001', 1, 9.99, 2),  -- John Doe mua 2 Margherita Pizza
('O001', 2, 12.99, 1), -- John Doe mua 1 Pepperoni Pizza
('O002', 3, 11.99, 1), -- Jane Smith mua 1 Veggie Supreme Pizza
('O003', 4, 13.99, 3); -- Peter Parker mua 3 BBQ Chicken Pizza





SELECT * FROM Categories
SELECT * FROM Suppliers
SELECT * FROM Products
SELECT * FROM Account
SELECT * FROM Cart
USE [PizzaStoreDB_Nam]
GO

INSERT INTO [dbo].[Account]
           ([UserName]
           ,[Password]
           ,[FullName]
           ,[Phone]
           ,[Email]
           ,[Type])
     VALUES
           (<UserName, varchar(255),>
           ,<Password, varchar(255),>
           ,<FullName, nvarchar(255),>
           ,<Phone, varchar(15),>
           ,<Email, varchar(50),>
           ,<Type, int,>)
GO



 SELECT p.*, c.CategoryName
               FROM [PizzaStoreDB].[dbo].[Products] p 
               	LEFT JOIN [PizzaStoreDB].[dbo].[Categories] c 
              	ON p.CategoryID = c.CategoryID 
                WHERE p.Sale = 1
UPDATE [dbo].[Account]
                 SET Role = 'admin'
            WHERE AccountID = 8
DELETE FROM Account WHERE AccountID = 7


