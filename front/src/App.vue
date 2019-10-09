<template>
    <v-app id="keep">
        <v-app-bar app clipped-left color="blue">
            <v-app-bar-nav-icon @click="drawer = !drawer"></v-app-bar-nav-icon>
            <span class="title ml-3 mr-5">Vow&nbsp;<span class="font-weight-light">Activity</span></span>
            <v-text-field solo-inverted flat hide-details label="Search" prepend-inner-icon="search"></v-text-field>
            <div class="flex-grow-1"></div>
        </v-app-bar>
        <v-navigation-drawer v-model="drawer" app clipped color="grey lighten-4">
            <v-list dense class="grey lighten-4">
                <template v-for="(item, i) in items">
                    <v-row v-if="item.heading" :key="i" align="center">
                        <v-col cols="6">
                            <v-subheader v-if="item.heading">
                                {{ item.heading }}
                            </v-subheader>
                        </v-col>
                        <v-col cols="6" class="text-right">
                            <v-btn small text>edit</v-btn>
                        </v-col>
                    </v-row>
                    <v-divider v-else-if="item.divider" :key="i" dark class="my-4"></v-divider>
                    <v-list-item v-else :key="i" @click="go(item)">
                        <v-list-item-action>
                            <v-icon>{{ item.icon }}</v-icon>
                        </v-list-item-action>
                        <v-list-item-content>
                            <v-list-item-title class="grey--text">
                                {{ item.text }}
                            </v-list-item-title>
                        </v-list-item-content>
                    </v-list-item>
                </template>
            </v-list>
        </v-navigation-drawer>
        <v-content>
            <router-view/>
        </v-content>
    </v-app>
</template>

<script>
    export default {
        name: 'App',
        data: () => ({
            drawer: null,
            items: [
                {icon: 'lightbulb_outline', text: 'Notes'},
                {icon: 'touch_app', text: 'Reminders'},
                {divider: true},
                {heading: 'Labels'},
                {icon: 'add', text: 'Create new label'},
                {divider: true},
                {icon: 'archive', text: 'Archive'},
                {icon: 'delete', text: 'Trash'},
                {divider: true},
                {icon: 'settings', text: 'Settings'},
                {icon: 'chat_bubble', text: 'Trash'},
                {icon: 'help', text: 'Help'},
                {icon: 'phonelink', text: 'App downloads'},
                {icon: 'keyboard', text: 'Keyboard shortcuts'},
            ],
        }),
        methods: {
            go (e) {
                console.log("gone " + JSON.stringify(e));
            }
        }
    };
</script>

<style>
    #keep .v-navigation-drawer__border {
        display: none
    }
</style>
