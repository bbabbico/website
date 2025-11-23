function saved(type,rank,img,url,name,brand,price){
    const item ={ //상품 정보 obj
        "img" :img,
        "url" :url,
        "name" :name,
        "brand" :brand,
        "price" :price
    }

    fetch("/ranking/wl",{
        method:"POST",
        body: JSON.stringify(item), //POST Body에 상품정보 JSON으로 담기
        headers: {
            'Content-Type': 'application/json' // 여기서 미디어 타입 지정
        }
        })
        .then((res)=>res.json())
        .then((data)=>console.log(data))

    document.getElementById(`saved_button_${type}_${rank}`).innerText = "❤"
}