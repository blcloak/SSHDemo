//Explain   :   使Table可以点击排序.

/*使用说明  :
方法1:
    new TableSorter("tb1");
效果:
    id为tb1的table的第一行任意单元格都可以点击进行排序.

方法2:
    new TableSorter("tb1", 0, 1, 3);
效果:
    id为tb1的table的第一行0,1,3单元格可以进行点击排序.
*/

function TableSorter(table)
{
    this.Table = this.$(table);
    if(this.Table.rows.length <= 1)
    {
        return;
    }
    var args = [];
    if(arguments.length > 1)
    {
        for(var x = 1; x < arguments.length; x++)
        {
            args.push(arguments[x]);
        }
    }
    this.Init(args);
}

TableSorter.prototype = {
    $ : function(element)//简写document.getElementById
    {
        return document.getElementById(element);
    },
    Init : function(args)//初始化表格的信息和操作
    {
        this.Rows = [];
        this.Header = [];
        this.ViewState = [];
        this.LastSorted = null;
        this.NormalCss = "NormalCss";
        this.SortAscCss = "SortAscCss";
        this.SortDescCss = "SortDescCss";
        for(var x = 0; x < this.Table.rows.length; x++)
        {
            this.Rows.push(this.Table.rows[x]);
        }
        this.Header = this.Rows.shift().cells;
        for(var x = 0; x < (args.length ? args.length : this.Header.length); x++)
        {
            var rowIndex = args.length ? args[x] : x;
            if(rowIndex >= this.Header.length)
            {
                continue;
            }
            this.ViewState[rowIndex] = false;
            this.Header[rowIndex].style.cursor = "pointer";
            this.Header[rowIndex].onclick = this.GetFunction(this, "Sort", rowIndex);
        }
    },
    GetFunction : function(variable,method,param)//取得指定对象的指定方法.
    {
        return function()
        {
            variable[method](param);
        }
    },
    Sort : function(column)//执行排序.
    {
        if(this.LastSorted)
        {
            this.LastSorted.className = this.NormalCss;
        }
        var SortAsNumber = true;
        for(var x = 0; x < this.Rows.length && SortAsNumber; x++)
        {
            SortAsNumber = this.IsNumeric(this.Rows[x].cells[column].innerHTML);
        }
        this.Rows.sort(
        function(row1, row2)
        {
            var result;
            var value1,value2;
            value1 = row1.cells[column].innerHTML;
            value2 = row2.cells[column].innerHTML;
            if(value1 == value2)
            {
                return 0;
            }
            if(SortAsNumber)
            {
                result = parseFloat(value1) > parseFloat(value2);
            }
            else
            {
                result = value1 > value2;
            }
            result = result ? 1 : -1;
            return result;
        })
        if(this.ViewState[column])
        {
            this.Rows.reverse();
            this.ViewState[column] = false;
            this.Header[column].className = this.SortDescCss;
        }
        else
        {
            this.ViewState[column] = true;
            this.Header[column].className = this.SortAscCss;
        }
        this.LastSorted = this.Header[column];
        var frag = document.createDocumentFragment();
        for(var x = 0; x < this.Rows.length; x++)
        {
            frag.appendChild(this.Rows[x]);
        }
        this.Table.tBodies[0].appendChild(frag);
        this.OnSorted(this.Header[column], this.ViewState[column]);
    },
    IsNumeric : function(num)//验证是否是数字类型.
    {
        return /^\d+(\.\d+)?$/.test(num);
    },
    OnSorted : function(cell, IsAsc)//排序完后执行的方法.cell:执行排序列的表头单元格,IsAsc:是否为升序排序.
    {
        return;
    }
}

/**
 * Filter
 */
var arrStore;
function onSearch(obj, table, column){//js函数开始  
    setTimeout(function(){//因为是即时查询，需要用setTimeout进行延迟，让值写入到input内，再读取  
        var storeId = document.getElementById(table);//获取table的id标识  
        var rowsLength = storeId.rows.length;//表格总共有多少行 
        if(!arrStore){
        	arrStore = new Array(rowsLength);
        }
        var key = obj.value;//获取输入框的值  
  
        for(var i=1;i<rowsLength;i++){//按表的行数进行循环，本例第一行是标题，所以i=1，从第二行开始筛选（从0数起）  
        	if(!arrStore[i]) arrStore[i] = [];
            var searchText = storeId.rows[i].cells[column].innerHTML;//取得table行，列的值  
  
            if(searchText.match(key)){//用match函数进行筛选，如果input的值，即变量 key的值为空，返回的是ture，  
            	if(arrStore[i].indexOf(column) >= 0) arrStore[i].splice(arrStore[i].indexOf(column), 1);
            }else{  
            	if(arrStore[i].indexOf(column) == -1) arrStore[i].push(column);
            }
            
            if(arrStore[i].length>0){
            	storeId.rows[i].style.display='none';//隐藏行操作  
            }else{
            	storeId.rows[i].style.display='';//显示行操作，  
            }
        }  
    },200);//200为延时时间  
}  