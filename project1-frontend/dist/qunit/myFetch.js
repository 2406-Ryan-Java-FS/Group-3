
/*
    Fetch method customized for hitting our endpoints
*/
async function myFetch(method,endpoint,returnJsonBody,additionalHeaders,postData)
{
    const response=await fetch(endpoint,
    {
        "method":method,
        headers:{"Content-Type":"application/json",...additionalHeaders},
        body:method=="GET"?null:JSON.stringify(postData)
    })

    //console.log(`response.status=`+response.status)

    if(response.status==500 || response.status==400)
    {
        let body=await response.json()
        if(body==undefined) 				throw new Error("response json body was undefined")
        if(body.errorMessages==undefined) 	throw new Error("response json body errorMessages was undefined")
        throw new Error(body.errorMessage)
    }
    else if(response.status!=200)
    {
        throw new Error([response.status,response.statusText,response.url])
    }

    if(returnJsonBody){
        try{
            return await response.json()
        }catch(e){
            return {}
        }
    }
    //console.log(`response=`+response)

    return response
}
