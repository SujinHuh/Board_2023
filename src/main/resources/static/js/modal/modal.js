
    let boardArea = document.getElementById('boardArea');

    // 클릭 이벤트 리스너 등록
    boardArea.addEventListener('click', function(event) {
    let target = event.target;
    if (target.classList.contains('board-title')) {
    let title = target.textContent;
    let content = target.nextElementSibling.textContent;
    showBoardModal(title, content);
}
});

    // 모달 창 보여주기
function showBoardModal(title, content) {
    let boardModal = document.getElementById('boardModal');
    let modalTitle = document.getElementById('boardModalLabel');
    let modalContent = document.getElementById('boardContent');
    modalTitle.textContent = title;
    modalContent.textContent = content;
    $(boardModal).modal('show');
}