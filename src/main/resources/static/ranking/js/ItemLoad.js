function qwe() {
    fetch("/ranking", {method: "POST"})
        .then(res => res.json())
        .then(data => {
            console.log(data)
            groupByPlatformArray(data);

        })
        .catch(err => console.error("API Error:", err));
}
function groupByPlatformArray(items) {
    const result = [];

    items.forEach(item => {
        const key = item.platform;
        if (!result[key]) {
            result[key] = [];
        }
        result[key].push(item);
    });

    renderRankingList(result[0]);
    renderRankingList(result[1]);
    renderRankingList(result[2]);
    renderRankingList(result[3]);
}

function renderRankingList(list) {
    console.log(`type${list[0].platform}-items`)
    const container = document.getElementById(`type${list[0].platform}-items`);
    container.innerHTML = "";

    list.forEach((item, index) => {
        if (index === 0) container.innerHTML += renderFirstItem(item);
        else container.innerHTML += renderOtherItem(item, index);
    });
}

function renderFirstItem(item) {
    return `
    <div id="main_div_${item.platform}_1" class="bg-white border border-emerald-200 rounded-xl shadow-md hover:shadow-lg transition p-4 w-full max-w-xs mx-auto">
      <a href="${item.url}" class="w-full h-52 bg-gray-100 rounded-lg flex items-center justify-center mb-4 block">
        <img src="${item.img}" alt="대표이미지" class="w-full h-full object-cover">
      </a>
      <div class="space-y-1 text-center">
        <div class="text-emerald-600 text-sm font-bold">1등</div>
        <div class="text-gray-800 font-semibold text-base truncate">${item.name}</div>
        <div class="text-gray-500 text-sm">${item.brand}</div>
        <div class="text-emerald-700 font-bold text-lg mt-2">${item.price}원</div>
        <button id="saved_button_${item.platform}_1" class="px-3 py-2 border border-gray-300 rounded-md hover:bg-gray-100 transition" 
        onclick="saved('${item.platform}',1,'${item.url}','${item.img}','${item.name}','${item.brand}','${item.price}원')">☮</button>
      </div>
    </div>
  `;
}
function renderOtherItem(item, index) {
    return `
    <div id="main_div_${item.platform}_${index}" class="bg-white border rounded-xl shadow-sm hover:shadow-md transition p-3 w-full max-w-xs mx-auto my-6">
      <a href="${item.url}" class="w-full h-52 bg-gray-100 rounded-lg overflow-hidden block mb-3">
        <img src="${item.img}" alt="대표 이미지" class="w-full h-full object-cover">
      </a>

      <div class="text-center space-y-1">
        <div class="text-emerald-600 text-sm font-bold">${index + 1}등</div>

        <div class="text-gray-800 font-medium text-sm overflow-hidden text-ellipsis"
             style="display: -webkit-box;-webkit-line-clamp: 3;-webkit-box-orient: vertical;">
          ${item.name.length > 50 ? item.name.substring(0, 50) + '…' : item.name}
        </div>

        <div class="text-gray-500 text-xs">${item.brand}</div>
        <div class="text-emerald-700 font-semibold text-base mt-1">${item.price}원</div>
        <button id="saved_button_${item.platform}_${index}" class="px-3 py-2 border border-gray-300 rounded-md hover:bg-gray-100 transition" 
        onclick="saved('${item.platform}',${index},'${item.url}','${item.img}','${item.name}','${item.brand}','${item.price}원')">☮</button>
      </div>
    </div>
  `;
}
window.onload = function() {
    qwe();}