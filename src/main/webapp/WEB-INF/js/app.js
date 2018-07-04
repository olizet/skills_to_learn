$(function () {

    function loadBooks() {
        $.ajax({
            url: "http://localhost:8080/skills/",
            type: "GET",
            dataType: "json"
        }).done(function(skills) {
            console.log(skills);
            $(skills).each(function (index, element) {
                addBookTitle(element.name, element.id);
            });
        })
    }

    function  addBookTitle(name, id) {
        var skillsList = $("#skills-list");
        var li = $("<li class='list-group-item'>");
        var p = $("<p class='noEdit'>");
        var div = $("<div class='skill-description'>");
        var deleteLink = $("<a href='#' class='delete-link btn btn-danger'>delete</a>");
        var editLink = $("<a href='#' class='success-link btn btn-success'>Edit</a>");

        li.appendTo(skillsList);
        p.attr("id", id).text(name).appendTo(li)
        div.appendTo(li);
        deleteLink.attr("data-skill", id).appendTo(li);
        editLink.attr("data-skill", id).appendTo(li);


        $("a.delete-link").on("click", function (e) {
            deleteBook( $(this).attr("data-skill") );
        })

        $("a.success-link").on("click", function (e) {
            editBook( $(this).attr("data-skill") );
        })

    }

    function deleteBook(id) {
        $("#skills-list").empty();
        $.ajax({
            type: 'DELETE',
            url: ("http://localhost:8080/skills/" + id)
        }).done(function (data) {
            loadBooks();
        })
    }
    function editBook(id) {
        $.ajax({
            type:'GET',
            url:("http://localhost:8080/skills/"+id)
        }).done(function(data){
            $("#id").val(data.id);
            $("#name").val(data.name);
            $("#description").val(data.description);
            $("#add_btn").addClass("edit")
            $("#edit_btn").removeClass("edit")
        })
    }

    function addBook() {

        var btn = $("#add_btn");

        btn.on("click", function (e) {
            e.preventDefault();
            var skill = {
                name : $("#name").val(),
                description : $("#description").val()
            };

            var bookToSend = JSON.stringify(skill);

            $.post({
                url: "http://localhost:8080/skills/",
                data: bookToSend,
                headers: {
                    'Accept': 'application/json',
                    'Content-Type': 'application/json'
                },
            }).done(function (data) {
                console.log(data)
                $("#skills-list").empty();
                loadBooks();
            });
        });
    }
    loadBooks();
    addBook();

})
