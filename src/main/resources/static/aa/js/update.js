// 當網頁載入完成
document.addEventListener('DOMContentLoaded', function() {
    
    // 從 URL 獲取 applicationNo
    const urlParams = new URLSearchParams(window.location.search);
    const applicationNo = urlParams.get('applicationNo');

    // 用來填充表單的原始數據
    fetch(`http://localhost:8080/adoptedapplications/${applicationNo}`)
    .then(response => response.json())
    .then(data => {
        const form = document.getElementById('updateForm');
        form['adminNo'].value = data.adminNo;
        form['memberNo'].value = data.memberNo;
        form['petId'].value = data.petId;
        form['interactionDate'].value = data.interactionDate;
        form['lotteryResult'].value = data.lotteryResult;
        form['lotteryDate'].value = data.lotteryDate;
        form['applicationStat'].value = data.applicationStat;
        form['applicantNotes'].value = data.applicantNotes;
        form['agreement'].value = data.agreement;
        form['applicationDate'].value = data.applicationDate;
    })
    .catch(error => {
        console.error('Error:', error);
    });

    // 監聽表單提交事件
    const form = document.getElementById('updateForm');
    form.addEventListener('submit', function(e) {
        
        // 防止表單自動提交
        e.preventDefault();
        
        // 獲取表單數據
        const formData = new FormData(form);
        const jsonData = Object.fromEntries(formData);
        
        // 更新數據
        fetch(`http://localhost:8080/adoptedapplications/${applicationNo}`, {
            method: 'PUT',
            headers: {
                'Content-Type': 'application/json',
            },
            body: JSON.stringify(jsonData),
        })
        .then(response => {
            if (response.status === 200) {
                alert('更新成功');
            } else {
                alert('更新失敗');
            }
        })
        .catch(error => {
            console.error('Error:', error);
        });
    });
});
