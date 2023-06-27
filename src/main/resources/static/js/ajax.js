let currentPageNumber = 0;
let totalPage = 0;
const pageSize = 2;
function search(){
    let search = $('#search').val();
    let display = "";
    $.ajax({
        type:"GET",
        url: "http://localhost:8080/api/blogs/search-by-author/" + search,

        success: function (result){
            console.log(result);
            display+= `
            <table border="1">
                 <tr>
                    <th>STT</th>
                    <th>Title</th>
                    <th>Content</th>
                    <th>Author</th>
                    <th>Category</th>
                    <th colspan="2">Action</th>
                </tr>
            `
            for (let i = 0; i < result.length; i++) {
                display += `
                <tr>
                    <td>${i + 1}</td>
  
                    <td>${result[i].title}</td>
                    <td>${result[i].content}</td>
                    <td>${result[i].author}</td>
                    <td>${result[i].category.name}</td>
                    <td><button onclick="showFormUpdate(${result[i].id})">Update</button></td>
                    <td><button onclick="deleteBlog(${result[i].id})">Delete</button></td>
                </tr>`
            }
            display+= `</table>`
            document.getElementById("display").innerHTML = display;
        }
    })
}


function showFormSearch(){
    let form = "";
    form += `
    <input type="search" id="search" placeholder="input search">
    <button onclick="search()">Search</button>
    `
    console.log("show form search")
    document.getElementById("display").innerHTML = form;
}

function showAllPaging(){
    $.ajax({
        type: "GET",
        url: `http://localhost:8080/api/blogs/paging?page=${currentPageNumber}&size=${pageSize}`,
        success: function (data) {
            console.log(data)
            totalPage = data.totalPages-1;
            let blog = "";
            blog +=
                `<table border="1"> 
                <tr>
                    <th>STT</th>
                    <th>ID</th>
                    <th>Title</th>
                    <th>Content</th>
                    <th>Author</th>
                    <th>Category</th>
                    <th colspan="2">Action</th>
                </tr>`
            for (let i = 0; i < data.content.length; i++) {
                blog += `
                <tr>
                    <td>${i + 1}</td>
                    <td>${data.content[i].id}</td>
                    <td>${data.content[i].title}</td>
                    <td>${data.content[i].content}</td>
                    <td>${data.content[i].author}</td>
                    <td>${data.content[i].category.name}</td>        
                    <td><button onclick="showFormUpdate(${data.content[i].id})">Update</button></td>
                     <td><button onclick="deleteBlog(${data.content[i].id})">Delete</button></td>
 
                </tr>`
            }
            blog += `</table>`

            blog += `
                <tr>
                    <td colspan="7">
                        <button onclick="goToPage('prev')">Previous</button>
                        <button onclick="goToPage('next')">Next</button>
                    </td>
                </tr>`;
            blog += `<p>` + currentPageNumber + `/` + `${data.totalPages}` + `</p>`
            document.getElementById("display").innerHTML = blog;
        }
    })
}

function goToPage(page) {
    if (page === 'prev' && currentPageNumber > 0) {
        currentPageNumber--;
    } else if (page === 'next'&& currentPageNumber<totalPage) {
        currentPageNumber++;
    }
    showAllPaging(); // Gọi lại hàm showAllPaging để hiển thị dữ liệu trang mới
}