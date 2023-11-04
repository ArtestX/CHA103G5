let offset = 0; // 初始的偏移量
const limit = 5; // 每頁顯示多少條記錄

// 使用 fetch API 來從後端撈取資料
function fetchData() {
    // 使用 fetch API 來從後端撈取資料
    fetch(`http://localhost:8080/adoptedapplications?limit=${limit}&offset=${offset}`)
        .then(response => response.json())
        .then(data => {
        let tableBody = document.getElementById('tableBody');
        tableBody.innerHTML = ""; // 清空表格
        // 使用 forEach 來遍歷每個領養申請

        // 顯示查詢到的總比數
        tableBody.innerHTML += `<tr><td colspan="11">總比數：${data.total}</td></tr>`;

        data.results.forEach(adoptedApplication => {
            let row = `<tr>
                            <td>${adoptedApplication.applicationNo}</td>
                            <td>${adoptedApplication.adminNo}</td>
                            <td>${adoptedApplication.memberNo}</td>
                            <td>${adoptedApplication.petId}</td>
                            <td>${adoptedApplication.lotteryDate}</td>
                            <td>${adoptedApplication.lotteryResult}</td>
                            <td>${adoptedApplication.interactionDate}</td>
                            <td>${adoptedApplication.applicationStat}</td>
                            <td>${adoptedApplication.applicantNotes}</td>
                            <td>${adoptedApplication.agreement}</td>
                            <td>${adoptedApplication.applicationDate}</td>
                            <td><button onclick="updateRecord(${adoptedApplication.applicationNo})">修改</button></td>
                            <td><button onclick="deleteRecord(${adoptedApplication.applicationNo})">刪除</button></td>      
                    </tr>`;
            tableBody.innerHTML += row;
        });
        // 計算總頁數
        const totalPages = Math.ceil(data.total / limit);

        // 生成頁碼
        let paginationHtml = '';
        for (let i = 1; i <= totalPages; i++) {
            paginationHtml += `<button onclick="goToPage(${i})">${i}</button>`;
        }
        document.getElementById('paginationall').innerHTML = paginationHtml;
    })
    .catch(error => {
        console.error('Error:', error);
    });
}

// 跳到指定頁碼
function goToPage(page) {
    offset = (page - 1) * limit;
    fetchData();
}

// 添加 updateRecord 函數
function updateRecord(applicationNo) {
    window.location.href = `update.html?applicationNo=${applicationNo}`;
}

// 添加 deleteRecord 函數
function deleteRecord(applicationNo) {
    const apiUrl = `http://localhost:8080/adoptedapplications/${applicationNo}`;
    fetch(apiUrl, {
        method: 'DELETE'
    })
    .then(response => {
        if (response.status === 204) {  // 使用 response.status 來檢查狀態碼
            alert('刪除成功');
            fetchData();
        } else {
            alert('刪除失敗');
        }
    })
    .catch(error => {
        console.error('Error:', error);
    });
}

// 上一頁和下一頁的功能
function prevPage() {
    if (offset >= limit) { // 確保偏移量不會變成負數
        offset -= limit;
        fetchData();
    }
}

function nextPage() {
    offset += limit;
    fetchData();
}

// 初始化時先載入第一頁的資料
fetchData();
