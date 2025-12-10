package com.example.wahtsapp.presentation.theme

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.CameraAlt
import androidx.compose.material.icons.filled.Chat
import androidx.compose.material.icons.filled.Check
import androidx.compose.material.icons.filled.CheckCircle
import androidx.compose.material.icons.filled.DoneAll
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.material.icons.filled.Phone
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material.icons.filled.Star
import androidx.compose.material.icons.filled.VolumeOff
import androidx.compose.material3.Badge
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Divider
import androidx.compose.material3.ElevatedButton
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.ui.graphics.Color

// ========== DATA MODELS ==========
data class ChatItem(
    val id: String,
    val name: String,
    val lastMessage: String,
    val time: String,
    val unreadCount: Int = 0,
    val isPinned: Boolean = false,
    val isMuted: Boolean = false,
    val isGroup: Boolean = false,
    val isOnline: Boolean = false,
    val isTyping: Boolean = false
)

data class Message(
    val id: String,
    val text: String,
    val time: String,
    val isSentByMe: Boolean = false,
    val isRead: Boolean = false,
    val isDelivered: Boolean = false
)

data class TabItem(
    val title: String,
    val icon: ImageVector,
    val badgeCount: Int = 0
)

// ========== DUMMY DATA ==========
val dummyChats = listOf(
    ChatItem("1", "John Doe", "Hey there! I'm using WhatsApp", "10:30 AM", 3, true, false, false, true, false),
    ChatItem("2", "Family Group", "Mom: Dinner at 7 PM", "9:45 AM", 12, true, true, true, false, false),
    ChatItem("3", "Sarah Smith", "See you tomorrow!", "Yesterday", 0, false, false, false, true, true),
    ChatItem("4", "Work Team", "Project deadline extended", "Yesterday", 0, false, false, true, false, false),
    ChatItem("5", "Alex Johnson", "Can you call me?", "Sunday", 1, false, true, false, false, false),
    ChatItem("6", "Jane Wilson", "👍", "Saturday", 0, false, false, false, true, false),
    ChatItem("7", "Marketing Dept", "Meeting notes attached", "Friday", 5, false, false, true, false, false),
    ChatItem("8", "Mike Brown", "Let's catch up soon", "Thursday", 0, false, false, false, false, false),
)

val dummyMessages = listOf(
    Message("1", "Hey there! How are you?", "10:15 AM", false, true, true),
    Message("2", "I'm good! Working on a new project", "10:16 AM", true, true, true),
    Message("3", "That's great! What's it about?", "10:17 AM", false, true, true),
    Message("4", "It's a WhatsApp UI clone in Jetpack Compose", "10:18 AM", true, false, true),
    Message("5", "Nice! Can I see the code?", "10:19 AM", false, false, true),
    Message("6", "Sure, I'll share it with you", "10:20 AM", true, false, false),
)

val tabs = listOf(
    TabItem("Chats", Icons.Default.Chat, 8),
    TabItem("Status", Icons.Default.AccountCircle),
    TabItem("Calls", Icons.Default.Settings, 3)
)

// ========== UI COMPONENTS ==========

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun WhatsAppTestScreen(
    modifier: Modifier = Modifier

) {
    var selectedTab by remember { mutableStateOf(0) }
    
    Scaffold(
        topBar = {
            TopAppBar(
                title = { 
                    Text(
                        "WhatsApp", 
                        fontWeight = FontWeight.Bold,
                        color = MaterialTheme.colorScheme.onPrimary
                    )
                },
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = MaterialTheme.colorScheme.primary
                ),
                actions = {
                    IconButton(onClick = {}) {
                        Icon(Icons.Default.Search, contentDescription = "Search")
                    }
                    IconButton(onClick = {}) {
                        Icon(Icons.Default.MoreVert, contentDescription = "More")
                    }
                }
            )
        },
        floatingActionButton = {
            Column(verticalArrangement = Arrangement.spacedBy(16.dp)) {
                FloatingActionButton(
                    onClick = {},
                    containerColor = IconGreen,
                    shape = CircleShape
                ) {
                    Icon(Icons.Default.CameraAlt, contentDescription = "Camera")
                }
                FloatingActionButton(
                    onClick = {},
                    containerColor = MaterialTheme.colorScheme.primary,
                    shape = CircleShape
                ) {
                    Icon(Icons.Default.Add, contentDescription = "New Chat")
                }
            }
        }
    ) { paddingValues ->
        Column(
            modifier = modifier
                .fillMaxSize()
                .padding(paddingValues)
        ) {
            // Tabs Row
            TabsRow(selectedTab, onTabSelected = { selectedTab = it })
            
            Divider(color = MaterialTheme.colorScheme.outline.copy(alpha = 0.3f))
            
            // Content based on selected tab
            when (selectedTab) {
                0 -> ChatsTab()
                1 -> StatusTab()
                2 -> CallsTab()
            }
            
            // Test Section with all components
            AllComponentsTestSection()
        }
    }
}

@Composable
fun TabsRow(selectedIndex: Int, onTabSelected: (Int) -> Unit) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .background(MaterialTheme.colorScheme.background)
    ) {
        tabs.forEachIndexed { index, tab ->
            TabItem(
                item = tab,
                isSelected = selectedIndex == index,
                onClick = { onTabSelected(index) },
                modifier = Modifier.weight(1f)
            )
        }
    }
}

@Composable
fun TabItem(
    item: TabItem,
    isSelected: Boolean,
    onClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    val textColor = if (isSelected) MaterialTheme.colorScheme.primary 
                    else MaterialTheme.colorScheme.onSurface.copy(alpha = 0.7f)
    
    Box(
        modifier = modifier
            .clickable(onClick = onClick)
            .padding(vertical = 12.dp),
        contentAlignment = Alignment.Center
    ) {
        Column(horizontalAlignment = Alignment.CenterHorizontally) {
            Box {
                Icon(
                    imageVector = item.icon,
                    contentDescription = item.title,
                    tint = textColor,
                    modifier = Modifier.size(24.dp)
                )
                
                if (item.badgeCount > 0) {
                    Badge(
                        containerColor = MaterialTheme.whatsAppColors.unreadBadge,
                        modifier = Modifier.align(Alignment.TopEnd)
                    ) {
                        Text(
                            text = item.badgeCount.toString(),
                            color = MaterialTheme.colorScheme.onPrimary,
                            fontSize = MaterialTheme.typography.labelSmall.fontSize
                        )
                    }
                }
            }
            
            Spacer(modifier = Modifier.height(4.dp))
            
            Text(
                text = item.title,
                color = textColor,
                fontSize = MaterialTheme.typography.labelSmall.fontSize,
                fontWeight = if (isSelected) FontWeight.Bold else FontWeight.Normal
            )
            
            if (isSelected) {
                Spacer(modifier = Modifier.height(2.dp))
                Box(
                    modifier = Modifier
                        .width(24.dp)
                        .height(3.dp)
                        .background(MaterialTheme.colorScheme.primary, CircleShape)
                )
            }
        }
    }
}

@Composable
fun ChatsTab() {
    Column(modifier = Modifier.fillMaxWidth()) {
        // Archived Chats
        Card(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp, vertical = 8.dp),
            shape = RoundedCornerShape(8.dp),
            colors = CardDefaults.cardColors(
                containerColor = MaterialTheme.colorScheme.surfaceVariant
            )
        ) {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 16.dp, vertical = 12.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Icon(
                    Icons.Default.Check,
                    contentDescription = "Archived",
                    tint = MaterialTheme.colorScheme.primary,
                    modifier = Modifier.size(20.dp)
                )
                Spacer(modifier = Modifier.width(12.dp))
                Text(
                    text = "Archived chats",
                    color = MaterialTheme.colorScheme.onSurface,
                    modifier = Modifier.weight(1f)
                )
                Text(
                    text = "12",
                    color = MaterialTheme.colorScheme.primary,
                    fontWeight = FontWeight.Bold
                )
            }
        }
        
        // Chat List
        LazyColumn {
            items(dummyChats) { chat ->
                ChatListItem(chat = chat)
                HorizontalDivider(
                    color = MaterialTheme.colorScheme.outline.copy(alpha = 0.2f),
                    thickness = 0.5.dp,
                    //startIndent = 72.dp
                )
            }
        }
    }
}

@Composable
fun ChatListItem(chat: ChatItem) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .clickable { }
            .padding(horizontal = 16.dp, vertical = 8.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        // Avatar with Status
        Box {
            Surface(
                shape = CircleShape,
                color = MaterialTheme.colorScheme.primary.copy(alpha = 0.2f),
                modifier = Modifier.size(56.dp)
            ) {
                Box(contentAlignment = Alignment.Center) {
                    Icon(
                        if (chat.isGroup) Icons.Default.AccountCircle else Icons.Default.AccountCircle,
                        contentDescription = "Avatar",
                        tint = MaterialTheme.colorScheme.primary,
                        modifier = Modifier.size(36.dp)
                    )
                }
            }
            
            // Online Status Indicator
            if (chat.isOnline) {
                Surface(
                    shape = CircleShape,
                    color = StatusOnline,
                    modifier = Modifier
                        .size(14.dp)
                        .align(Alignment.BottomEnd)
                        .border(2.dp, MaterialTheme.colorScheme.background, CircleShape)
                ) {}
            }
            
            // Pin Indicator
            if (chat.isPinned) {
                Icon(
                    Icons.Default.Star,
                    contentDescription = "Pinned",
                    tint = PinnedChatColor,
                    modifier = Modifier
                        .size(16.dp)
                        .align(Alignment.TopEnd)
                        .background(MaterialTheme.colorScheme.background, CircleShape)
                )
            }
        }
        
        Spacer(modifier = Modifier.width(12.dp))
        
        // Chat Info
        Column(
            modifier = Modifier.weight(1f)
        ) {
            Row(verticalAlignment = Alignment.CenterVertically) {
                Text(
                    text = chat.name,
                    color = MaterialTheme.colorScheme.onSurface,
                    fontWeight = FontWeight.Bold,
                    fontSize = MaterialTheme.typography.bodyLarge.fontSize,
                    modifier = Modifier.weight(1f)
                )
                Text(
                    text = chat.time,
                    color = if (chat.unreadCount > 0) MaterialTheme.colorScheme.primary 
                           else MaterialTheme.colorScheme.onSurfaceVariant,
                    fontSize = MaterialTheme.typography.labelSmall.fontSize
                )
            }
            
            Spacer(modifier = Modifier.height(4.dp))
            
            Row(verticalAlignment = Alignment.CenterVertically) {
                // Typing Indicator
                if (chat.isTyping) {
                    Text(
                        text = "typing...",
                        color = StatusTyping,
                        fontSize = MaterialTheme.typography.bodySmall.fontSize,
                        maxLines = 1,
                        overflow = TextOverflow.Ellipsis,
                        modifier = Modifier.weight(1f)
                    )
                } else {
                    Text(
                        text = chat.lastMessage,
                        color = if (chat.unreadCount > 0) MaterialTheme.colorScheme.onSurface 
                               else MaterialTheme.colorScheme.onSurfaceVariant,
                        fontSize = MaterialTheme.typography.bodySmall.fontSize,
                        maxLines = 1,
                        overflow = TextOverflow.Ellipsis,
                        modifier = Modifier.weight(1f)
                    )
                }
                
                // Chat Icons
                Row(
                    horizontalArrangement = Arrangement.spacedBy(4.dp),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    if (chat.isMuted) {
                        Icon(
                            Icons.Default.VolumeOff,
                            contentDescription = "Muted",
                            tint = MutedChatColor,
                            modifier = Modifier.size(16.dp)
                        )
                    }
                    
                    if (chat.unreadCount > 0) {
                        Surface(
                            shape = CircleShape,
                            color = MaterialTheme.whatsAppColors.unreadBadge,
                            modifier = Modifier.size(20.dp)
                        ) {
                            Box(contentAlignment = Alignment.Center) {
                                Text(
                                    text = chat.unreadCount.toString(),
                                    color = MaterialTheme.colorScheme.onPrimary,
                                    fontSize = MaterialTheme.typography.labelSmall.fontSize,
                                    fontWeight = FontWeight.Bold
                                )
                            }
                        }
                    }
                }
            }
        }
    }
}

@Composable
fun StatusTab() {
    Column(modifier = Modifier.fillMaxWidth()) {
        // My Status
        Card(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            shape = RoundedCornerShape(12.dp),
            colors = CardDefaults.cardColors(
                containerColor = MaterialTheme.colorScheme.surfaceVariant
            )
        ) {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Surface(
                    shape = CircleShape,
                    color = MaterialTheme.colorScheme.primary.copy(alpha = 0.2f),
                    modifier = Modifier.size(60.dp)
                ) {
                    Box(contentAlignment = Alignment.Center) {
                        Icon(
                            Icons.Default.AccountCircle,
                            contentDescription = "My Status",
                            tint = MaterialTheme.colorScheme.primary,
                            modifier = Modifier.size(40.dp)
                        )
                        FloatingActionButton(
                            onClick = {},
                            containerColor = IconGreen,
                            shape = CircleShape,
                            modifier = Modifier
                                .size(24.dp)
                                .align(Alignment.BottomEnd)
                        ) {
                            Icon(Icons.Default.Add, contentDescription = "Add", modifier = Modifier.size(12.dp))
                        }
                    }
                }
                
                Spacer(modifier = Modifier.width(16.dp))
                
                Column {
                    Text(
                        text = "My Status",
                        color = MaterialTheme.colorScheme.onSurface,
                        fontWeight = FontWeight.Bold,
                        fontSize = MaterialTheme.typography.titleMedium.fontSize
                    )
                    Text(
                        text = "Tap to add status update",
                        color = MaterialTheme.colorScheme.onSurfaceVariant,
                        fontSize = MaterialTheme.typography.bodySmall.fontSize
                    )
                }
            }
        }
        
        // Recent Updates
        Text(
            text = "Recent updates",
            color = MaterialTheme.colorScheme.onSurfaceVariant,
            fontSize = MaterialTheme.typography.labelLarge.fontSize,
            modifier = Modifier.padding(horizontal = 16.dp, vertical = 8.dp)
        )
        
        LazyColumn {
            items(dummyChats.take(3)) { chat ->
                StatusListItem(chat = chat)
            }
        }
    }
}

@Composable
fun StatusListItem(chat: ChatItem) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .clickable { }
            .padding(horizontal = 16.dp, vertical = 12.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Surface(
            shape = CircleShape,
            color = MaterialTheme.colorScheme.primary.copy(alpha = 0.2f),
            border = BorderStroke(
                2.dp,
                if (chat.unreadCount > 0) MaterialTheme.colorScheme.primary 
                else MaterialTheme.colorScheme.outline
            ),
            modifier = Modifier.size(56.dp)
        ) {
            Box(contentAlignment = Alignment.Center) {
                Icon(
                    Icons.Default.AccountCircle,
                    contentDescription = "Status",
                    tint = MaterialTheme.colorScheme.primary,
                    modifier = Modifier.size(36.dp)
                )
            }
        }
        
        Spacer(modifier = Modifier.width(16.dp))
        
        Column {
            Text(
                text = chat.name,
                color = MaterialTheme.colorScheme.onSurface,
                fontWeight = FontWeight.Medium
            )
            Text(
                text = "30 minutes ago",
                color = MaterialTheme.colorScheme.onSurfaceVariant,
                fontSize = MaterialTheme.typography.bodySmall.fontSize
            )
        }
    }
}

@Composable
fun CallsTab() {
    Column(modifier = Modifier.fillMaxWidth()) {
        // Call Buttons Row
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            horizontalArrangement = Arrangement.spacedBy(12.dp)
        ) {
            OutlinedButton(
                onClick = {},
                modifier = Modifier.weight(1f),
                colors = ButtonDefaults.outlinedButtonColors(
                    containerColor = MaterialTheme.colorScheme.surfaceVariant
                )
            ) {
                Icon(Icons.Default.Add, contentDescription = "Create Call Link", modifier = Modifier.size(20.dp))
                Spacer(modifier = Modifier.width(8.dp))
                Text("Create call link")
            }
            
            OutlinedButton(
                onClick = {},
                modifier = Modifier.weight(1f),
                colors = ButtonDefaults.outlinedButtonColors(
                    containerColor = MaterialTheme.colorScheme.surfaceVariant
                )
            ) {
                Icon(Icons.Default.Settings, contentDescription = "Settings", modifier = Modifier.size(20.dp))
                Spacer(modifier = Modifier.width(8.dp))
                Text("Settings")
            }
        }
        
        LazyColumn {
            items(dummyChats.take(5)) { chat ->
                CallListItem(chat = chat)
                HorizontalDivider(
                    color = MaterialTheme.colorScheme.outline.copy(alpha = 0.2f),
                    thickness = 0.5.dp,
                    //startIndent = 72.dp
                )
            }
        }
    }
}

@Composable
fun CallListItem(chat: ChatItem) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .clickable { }
            .padding(horizontal = 16.dp, vertical = 12.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Surface(
            shape = CircleShape,
            color = MaterialTheme.colorScheme.primary.copy(alpha = 0.2f),
            modifier = Modifier.size(56.dp)
        ) {
            Box(contentAlignment = Alignment.Center) {
                Icon(
                    Icons.Default.AccountCircle,
                    contentDescription = "Avatar",
                    tint = MaterialTheme.colorScheme.primary,
                    modifier = Modifier.size(36.dp)
                )
            }
        }
        
        Spacer(modifier = Modifier.width(16.dp))
        
        Column(modifier = Modifier.weight(1f)) {
            Text(
                text = chat.name,
                color = MaterialTheme.colorScheme.onSurface,
                fontWeight = FontWeight.Medium
            )
            Row(verticalAlignment = Alignment.CenterVertically) {
                Icon(
                    Icons.Default.Check,
                    contentDescription = "Call Direction",
                    tint = if (chat.unreadCount > 0) IconRed else IconBlue,
                    modifier = Modifier.size(16.dp)
                )
                Spacer(modifier = Modifier.width(4.dp))
                Text(
                    text = if (chat.unreadCount > 0) "Missed call" else "Outgoing",
                    color = if (chat.unreadCount > 0) IconRed else MaterialTheme.colorScheme.onSurfaceVariant,
                    fontSize = MaterialTheme.typography.bodySmall.fontSize
                )
            }
        }
        
        Column(horizontalAlignment = Alignment.End) {
            Text(
                text = chat.time,
                color = MaterialTheme.colorScheme.onSurfaceVariant,
                fontSize = MaterialTheme.typography.labelSmall.fontSize
            )
            if (chat.unreadCount > 0) {
                Spacer(modifier = Modifier.height(4.dp))
                Icon(
                    Icons.Default.Phone,
                    contentDescription = "Call back",
                    tint = MaterialTheme.colorScheme.primary,
                    modifier = Modifier.size(20.dp)
                )
            }
        }
    }
}

@Composable
fun AllComponentsTestSection() {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp)
            .background(MaterialTheme.colorScheme.surfaceVariant, RoundedCornerShape(12.dp))
            .padding(16.dp)
    ) {
        Text(
            text = "COLOR TEST SECTION",
            color = MaterialTheme.colorScheme.primary,
            fontWeight = FontWeight.Bold,
            fontSize = MaterialTheme.typography.titleMedium.fontSize
        )
        
        Spacer(modifier = Modifier.height(16.dp))
        
        // Message Bubbles Test
        Text(
            text = "Message Bubbles",
            color = MaterialTheme.colorScheme.onSurface,
            fontWeight = FontWeight.Medium
        )
        
        Spacer(modifier = Modifier.height(8.dp))
        
        Column(verticalArrangement = Arrangement.spacedBy(8.dp)) {
            // Incoming Message
            MessageBubble(
                text = "This is an incoming message",
                isSentByMe = false,
                time = "10:15 AM"
            )
            
            // Outgoing Message
            MessageBubble(
                text = "This is an outgoing message",
                isSentByMe = true,
                time = "10:16 AM",
                isRead = true
            )
            
            // Outgoing Unread
            MessageBubble(
                text = "This is unread",
                isSentByMe = true,
                time = "10:17 AM",
                isRead = false
            )
        }
        
        Spacer(modifier = Modifier.height(16.dp))
        
        // Buttons Test
        Text(
            text = "Buttons",
            color = MaterialTheme.colorScheme.onSurface,
            fontWeight = FontWeight.Medium
        )
        
        Spacer(modifier = Modifier.height(8.dp))
        
        Column(verticalArrangement = Arrangement.spacedBy(8.dp)) {
            Button(onClick = {}) {
                Text("Primary Button")
            }
            
            OutlinedButton(onClick = {}) {
                Text("Outlined Button")
            }
            
            ElevatedButton(onClick = {}) {
                Text("Elevated Button")
            }
        }
        
        Spacer(modifier = Modifier.height(16.dp))
        
        // Status Indicators
        Text(
            text = "Status Indicators",
            color = MaterialTheme.colorScheme.onSurface,
            fontWeight = FontWeight.Medium
        )
        
        Spacer(modifier = Modifier.height(8.dp))
        
        Row(horizontalArrangement = Arrangement.spacedBy(16.dp)) {
            StatusIndicator(StatusOnline, "Online")
            StatusIndicator(StatusOffline, "Offline")
            StatusIndicator(StatusTyping, "Typing")
        }
        
        Spacer(modifier = Modifier.height(16.dp))
        
        // Icon Colors
        Text(
            text = "Icon Colors",
            color = MaterialTheme.colorScheme.onSurface,
            fontWeight = FontWeight.Medium
        )
        
        Spacer(modifier = Modifier.height(8.dp))
        
        Row(horizontalArrangement = Arrangement.spacedBy(16.dp)) {
            IconColorTest(IconBlue, "Blue")
            IconColorTest(IconGreen, "Green")
            IconColorTest(IconRed, "Red")
            IconColorTest(IconYellow, "Yellow")
        }
    }
}

@Composable
fun MessageBubble(text: String, isSentByMe: Boolean, time: String, isRead: Boolean = false) {
    val bubbleColor = if (isSentByMe) MaterialTheme.chatBubbleOutgoing 
                     else MaterialTheme.chatBubbleIncoming
    val textColor = if (isSentByMe) MaterialTheme.colorScheme.onPrimaryContainer 
                   else MaterialTheme.colorScheme.onSurface
    
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(start = if (isSentByMe) 32.dp else 0.dp, end = if (isSentByMe) 0.dp else 32.dp)
    ) {
        Box(
            modifier = Modifier
                .clip(RoundedCornerShape(12.dp))
                .background(bubbleColor)
                .padding(horizontal = 12.dp, vertical = 8.dp)
        ) {
            Column {
                Text(
                    text = text,
                    color = textColor,
                    fontSize = MaterialTheme.typography.bodyMedium.fontSize
                )
                
                Spacer(modifier = Modifier.height(2.dp))
                
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.End,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(
                        text = time,
                        color = textColor.copy(alpha = 0.7f),
                        fontSize = MaterialTheme.typography.labelSmall.fontSize
                    )
                    
                    if (isSentByMe) {
                        Spacer(modifier = Modifier.width(4.dp))
                        Icon(
                            if (isRead) Icons.Default.DoneAll else Icons.Default.Check,
                            contentDescription = "Status",
                            tint = if (isRead) IconBlue else textColor.copy(alpha = 0.7f),
                            modifier = Modifier.size(12.dp)
                        )
                    }
                }
            }
        }
    }
}

@Composable
fun StatusIndicator(color: Color, label: String) {
    Column(horizontalAlignment = Alignment.CenterHorizontally) {
        Surface(
            shape = CircleShape,
            color = color,
            modifier = Modifier.size(24.dp)
        ) {}
        Spacer(modifier = Modifier.height(4.dp))
        Text(
            text = label,
            color = MaterialTheme.colorScheme.onSurfaceVariant,
            fontSize = MaterialTheme.typography.labelSmall.fontSize
        )
    }
}

@Composable
fun IconColorTest(color: Color, label: String) {
    Column(horizontalAlignment = Alignment.CenterHorizontally) {
        Surface(
            shape = CircleShape,
            color = color.copy(alpha = 0.2f),
            modifier = Modifier.size(40.dp)
        ) {
            Box(contentAlignment = Alignment.Center) {
                Icon(
                    Icons.Default.CheckCircle,
                    contentDescription = label,
                    tint = color,
                    modifier = Modifier.size(24.dp)
                )
            }
        }
        Spacer(modifier = Modifier.height(4.dp))
        Text(
            text = label,
            color = MaterialTheme.colorScheme.onSurfaceVariant,
            fontSize = MaterialTheme.typography.labelSmall.fontSize
        )
    }
}


