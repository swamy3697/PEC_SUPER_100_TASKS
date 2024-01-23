import random
class Product:
    def _init_(self,productname,productPrice,productquantity):
        self.productname=productname
        self.productPrice=productPrice
        self.productquantity=productquantity

class products:
    productslist =list()
    def add_product(productname,productPrice,productquantity):    
        product = Product(productname,productPrice,productquantity)
        products.productslist.append(product)
    def remove_product(name):
            for i in products.productslist:
                if i.productname==name:
                    products.productslist.remove(i)
                    return
            print("removed")
    def get_product_details(name):
        for product in products.productslist:
            if product.productname==name:
                print(product.productname)
                print(product.productPrice)
                print(product.productquantity)
                return
    def show_all_products():
        count=0
        for product in products.productslist:
                count+=1
                print(str(count)+"product "+product.productname)  
    def get_product(pname):
        p=None
        for product in products.productslist:
            if pname==product.productname:
                p=product
        return p        


class User:
    cart=list()
    history=list()
    #product_Obj=Product
    def _init_(self,name,age,address,user_id):
        self.name=name
        self.age=age
        self.address=address
        self.user_id=user_id
    def add_to_cart(self,product):
        User.cart.append(product)
    def place_order(self,product):
        User.history.append(product)
    def show_cart(self):
        if(len(self.cart)==0):
            print("the cart is empty")
            return
        for product in User.cart:
            print(product.productname)
    def show_history(self):
        for product in User.history:
            print(product.productname)
    def remove_from_cart(self):
        print('your cart')
        User.show_cart()
        pname=input("enter product name from above")
        for product in User.cart:
            if(product.productname==pname):
                User.cart.remove(product)
                print("removed product")
                return
        print("invalid product name")
class Shopping:
    def add_or_remove_from_cart(self):
        print("1 for remove product from cart")
        print("2 for add product to cart")
        choice=int(input("Enter your choice"))
        if(choice==1):
            self.user.remove_from_cart()
        else:
            pname=input("enter product name that you want to add")
            p= products.get_product(pname)
            if p is not None and  p not in Shopping.user.cart:
                Shopping.user.add_to_cart(p)
                return
            print("already added to cart or no such products availble ")
    def show_cart():
        Shopping.user.show_cart()
        choice=input('are you want to add or delete any product to cart Y/N')
        if(choice=='Y' or choice=='y'):
            Shopping.add_or_remove_from_cart()

    def showProducts():
        print("Availble products")
        products.show_all_products()
        print("are you want to buy any of these Y/N")
        choice=input('Enter your choice')
        if(choice=='Y' or choice=='y'):
            pname=input("Enter product name that you want but")
            p=products.get_product(pname)
            if p is not None:
                Shopping.user.place_order(p)
                return
            print("invalid product name")
        print('.....')           
    def remove_product_from_product_list():
        products.show_all_products()
        name=input("choose which product are you want to remove")
        products.remove_product(name)

    def add_product():
        name=input("enter product name")
        price=int(input("enter price of the product"))
        quantity=int(input("enter how many products you are adding [quantity of products]"))
        p=products.get_product(name) 
        if p is None:
            products.add_product(name,price,quantity)
            print("successfully added")
            return
        p.productquantity+=quantity
    def login():
        print('welcome to login page::')

        name=input("enter your name")
        
        age=int(input("enter your age"))
        address=input("enter your address")
        user_id=random.randint(1000000,99999999)
        return User(name,age,address,user_id)  
    user=login()
                   
def main():
        
        isInApp=True
        print("welcome to shoppy")
        print("choose options")
        print("1 : show all products")
        print("2 : open cart")
        print("3 : open shopping history")
        print("4 : open shopping")
        print("5 : remove product")
        print("6 : add product")
        print("7 : exit")
        choice=int(input("Enter your choice of action"))
        match choice:
            case 1:
                Shopping.showProducts()
            case 2:
                Shopping.show_cart()
            case 3:
                Shopping.user.show_history()
            case 4:
                Shopping.showProducts()
            case 5:
                products.remove_product()
            case 6:
                Shopping.add_product()
            case 7:
                isInApp=False
            case _:
                print("invalid choice")
        if(isInApp):
            main() 
         

if _name_ == "_main_":
    main()
