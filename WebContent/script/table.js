function moveOption(e1, e2){
    try{
         for(var i=0;i<e1.li.length;i++){
             if(e1.li[i].selected){
                var e = e1.li[i];
                e2.li.add(new Option(e.text, e.value));
                e1.remove(i);
                i=i-1
            }
        }
         document.addform.city.value=getvalue(document.addform.list2);
    }
    catch(e){}
}
function getvalue(geto){
    var allvalue = "";
    for(var i=0;i<geto.li.length;i++){
        allvalue +=geto.li[i].value + ",";
    }
    return allvalue;
}