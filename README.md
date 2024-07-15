# Group-3

### what application is about
Banking or Eccomerce or Revature paid training Application:

### what technologies are required for the application
API built with Java 17+ and Spring Boot 3+
UI built with React with TypeScript/JavaScript

### stories (pending approval)
Users can Create new accounts;
Users can Read and search own account details;
Users can update to and from an account wallet;
Admin accounts can delete or update user accounts;
Third type of account: Trainer adding course, IT, Dev, middle manager account (over a few users but under Admin)
Users can add online items to cart;
Users can Create reviews on items;
User can purchase items from cart if account holds enough money;
Admins can see remaining stock and order more;
Users and Admins can login to account;
All Users and Admins can reset passwords;

stretch:
Use Paypal in app
Put video trainings in app

Database:
Tables: Review, User, Item table, 

Review- item_id, review_id, text
User - Name, money, account type
Item table - Name, item_id, cost


### how to run the application

### any relevant information for a new team to pick up the project

nginx gateway can be useful for local development and on the server

# Using nginx gateway to serve frontend files and proxy requests to running backend jars

WHY?
1. So you can edit and serve frontend files even when your backend is not working.
2. So you can proxy many requests from a frontend to any backend. microservice ideas.
3. So you can avoid CORS errors because the browser is going through the same port, 80.
4. So can easily setup https on your server in the future.

Download stable nginx command line tool https://nginx.org/en/download.html

1. Extract files to your home folder ~/

2. create and place nginx.exe into a bin folder at ~/bin/nginx.exe

3. open ~/conf/nginx.conf to configure it for proxying requests

4. Inside nginx.conf within http {} section, within server {} section, add two locations to redirect:
```
location /project1-back/ {
	proxy_pass http://localhost:8080/;
}

location /project1/ {
	alias C:/Users/YOURNAME/Group-3/project1-frontend/dist/;
	try_files $uri $uri/ =404;
}
```
5. Goto command line or gitbash and start nginx from your home folder ~
start nginx

6. In the browser, on port 80, goto localhost/project1/index.html

When changes are made to nginx.conf, reload the config using:
nginx -s reload

If you see this error, start nginx
nginx: [error] OpenEvent("Global\ngx_reload_9456") failed (2: The system cannot find the file specified)

