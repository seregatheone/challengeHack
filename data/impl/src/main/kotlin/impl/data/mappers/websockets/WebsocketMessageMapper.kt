package impl.data.mappers.websockets

import basic.domain.websocket.WebsocketMessageReceivedEntity
import basic.domain.websocket.WebsocketMessageSendEntity
import websockets.dto.request.WebsocketMessageSendDto
import websockets.dto.response.WebsocketMessageReceivedDto


fun WebsocketMessageSendEntity.toEntity(): WebsocketMessageSendDto {
    return WebsocketMessageSendDto(
        content = content,
        sendTimestamp = sendTimestamp,
        replyId = replyId,
        fileIds = fileIds,
    )
}

fun WebsocketMessageReceivedDto.toEntity(): WebsocketMessageReceivedEntity {
    return WebsocketMessageReceivedEntity(
        text = this.content,
        sendTime = this.sendTimestamp,
        senderId = this.senderId
    )
}