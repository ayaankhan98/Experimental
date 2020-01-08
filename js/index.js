document.addEventListener('DOMContentLoaded', () => {

    window.onscroll = () => {
        if(window.scrollY > 280)
         {
            const nav = Handlebars.compile(document.querySelector('#top-nav-template').innerHTML)
            if(document.querySelector('#append-top-nav').innerHTML === ""){
                document.querySelector('#append-top-nav').innerHTML = nav()
            }
         }
         if(window.scrollY < 280)
         {
            document.querySelector('#append-top-nav').innerHTML = ""
         }
    }
    const blog = Handlebars.compile(document.querySelector('#blog-template').innerHTML)
    document.querySelector('#append').innerHTML = blog()

    document.addEventListener('click',event => {
        if(event.target.id === "about-click"){
            const about = Handlebars.compile(document.querySelector('#about-template').innerHTML)  
            document.querySelector('#append').innerHTML = about()
            document.querySelector('#about-click').className = "nav-link active"
            document.querySelector('#contact-click').className = "nav-link"
            document.querySelector('#blog-click').className = "nav-link"
        }
        else if(event.target.id ==="contact-click"){
            const contact = Handlebars.compile(document.querySelector('#contact-template').innerHTML)
            document.querySelector('#append').innerHTML = contact()
            document.querySelector('#contact-click').className = "nav-link active"
            document.querySelector('#about-click').className = "nav-link"
            document.querySelector('#blog-click').className = "nav-link"
        }
        else if(event.target.id === "blog-click"){
            const blog = Handlebars.compile(document.querySelector('#blog-template').innerHTML)
            document.querySelector('#append').innerHTML = blog()
            document.querySelector('#blog-click').className = "nav-link active"
            document.querySelector('#about-click').className = "nav-link"
            document.querySelector('#contact-click').className = "nav-link"
        }
    })

   
})