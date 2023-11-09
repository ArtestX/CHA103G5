// 定義 createApplication 函數
function createApplication() {
    // 從表單中獲取資料
    const adminNo = document.getElementById("adminNo").value;
    const memberNo = document.getElementById("memberNo").value;
    const petId = document.getElementById("petId").value;
    const lotteryDate = document.getElementById("lotteryDate").value;
    const lotteryResult = document.getElementById("lotteryResult").value;
    const interactionDate = document.getElementById("interactionDate").value;
    const applicationStat = document.getElementById("applicationStat").value;
    const applicantNotes = document.getElementById("applicantNotes").value;
    const agreement = document.getElementById("agreement").value;
    const applicationDate = document.getElementById("applicationDate").value;

    // 建立要傳送的資料物件
    const data = {
        adminNo,
        memberNo,
        petId,
        lotteryDate,
        lotteryResult,
        interactionDate,
        applicationStat,
        applicantNotes,
        agreement,
        applicationDate
    };

    // 使用 fetch API 進行 POST 請求
    fetch('http://localhost:8080/adoptedapplications', {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json'
        },
        body: JSON.stringify(data)
    })
    .then(response => {
        if (response.status === 201) { // 檢查狀態碼是否為 201 Created
            alert('新增成功！');
        } else {
            return response.json().then(data => {
                alert('新增失敗：' + data.message);
            });
        }
    })
    .catch((error) => {
        console.error('Error:', error);
    });
}
