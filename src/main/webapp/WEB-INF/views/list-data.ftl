<#if buyingInfos?exists && buyingInfos?size gt 0>
    <#list buyingInfos as info>
        <li>
            <div class="pro-list-box">
                <a href="/detail/${info.id}.htm" class="pro-img-box">
                    <img src="${info.picture}" alt=""/>
                    <i></i><span>${info.id}</span>
                </a>
                <div class="pro-info-box clearfix">
                    <div class="pro-info-text">
                       ${info.username}，${age(info.birthday?string("yyyy"))}岁，${info.addressCity}人<br><br>
                    </div>
                    <div class="share-like-box js_praise_btn" info_id = "${info.id}">
                        <i class="like-a"></i>
                        <span class="like-text js_praise">${info.praiseNum}</span>
                    </div>
                    <div class="share-a-box">
                        <i class="share-a"></i>
                    </div>
                </div>
            </div>
        </li>
    </#list>
</#if>