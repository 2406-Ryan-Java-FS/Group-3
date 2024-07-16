
/*
    Attemping to use controllers on the frontend.
    These can manage state/data.
    These can hold functions which can be called from React OR qunit for testing.

    Attempting to make the app testable.
    React side will go through menus/pages/modals and 
    make things look pretty, but I would like it to be 
    as dumb as possible so we aren't tangled in state management hell.
*/
export default class userAccountController
{
    loggedInUser=null
    
    static register(username,password)
    {
        console.log(`register ${username} ${password}`)
    }

    static login(username,password)
    {
        console.log(`login ${username} ${password}`)
    }

    static logout()
    {

    }

    static myPrivateInfo()
    {

    }
}