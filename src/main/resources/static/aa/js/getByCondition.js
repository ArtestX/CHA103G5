// 初始化 offset 和 limit
let offset = 0;
const limit = 5;

// 獲取 URL 查詢參數
function buildApiUrl() {
    const urlParams = new URLSearchParams(window.location.search);
    const memberNo = urlParams.get('memberNo');
    const petId = urlParams.get('petId');
    const lotteryDate = urlParams.get('lotteryDate');

    // 建構 API 的 URL
    let apiUrl = `http://localhost:8080/adoptedapplications?limit=${limit}&offset=${offset}`;
    if (memberNo) apiUrl += `&memberNo=${memberNo}`;
    if (petId) apiUrl += `&petId=${petId}`;
    if (lotteryDate) apiUrl += `&lotteryDate=${lotteryDate}`;
    
    return apiUrl;
}

// 使用 fetch API 來從後端撈取資料
function fetchData() {
    fetch(buildApiUrl())
        .then(response => response.json())
        .then(data => {
        let tableBody = document.getElementById('tableBody');
        tableBody.innerHTML = ""; // 清空表格
        
        // 顯示查詢到的總比數
        tableBody.innerHTML += `<tr><td colspan="11">總比數：${data.total}</td></tr>`;
        
        // 使用 forEach 來遍歷每個領養申請
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
