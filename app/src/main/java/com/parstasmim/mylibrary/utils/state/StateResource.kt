package com.parstasmim.mylibrary.utils.state

data class StateMessage(val response: MessageResponse)

data class MessageResponse(
    val message: String?,
    val uiComponentType: UIComponentType,
    val messageType: MessageType
)

sealed class UIComponentType{
    class Toast: UIComponentType()
    class Dialog: UIComponentType()
    class None: UIComponentType()
}

sealed class MessageType{
    class Success: MessageType()
    class Error: MessageType()
    class Info: MessageType()
    class None: MessageType()
}

interface StateMessageCallback{
    fun removeMessageFromStack()
}

fun StateMessage.doesMessageAlreadyExistInQueue(
    queue: Queue<StateMessage>,
): Boolean {
    for(item in queue.items){
        if(item.response.message == response.message){
            return true
        }
        if(item.response.messageType == response.messageType){
            return true
        }
        if(item.response.uiComponentType == response.uiComponentType){
            return true
        }
    }
    return false
}

interface AreYouSureCallback {
    fun proceed()
    fun cancel()
}










