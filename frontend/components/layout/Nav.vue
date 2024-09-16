<template>
    <nav class="relative mx-8 mb-24 mb-[45px] flex items-center justify-between pb-6 pt-12 font-medium md:mx-16 lg:mx-32">
        <svg
            class="absolute bottom-0 left-1/2 -translate-x-1/2"
            width="250"
            height="4"
            viewBox="0 0 250 4"
            fill="none"
            xmlns="http://www.w3.org/2000/svg"
        >
            <path
                class="animate-path"
                d="M2 2L428 1.99996"
                stroke="#282828"
                stroke-width="2"
                stroke-linecap="round"
            />
        </svg>

        <div :class="['flex gap-12', { 'opacity-1': !toggled.value, 'opacity-0': toggled.value }]">
            <div class="hidden items-center gap-12 xl:flex">
<!--                <img class="h-[40px]" src="/booking.svg" alt="booking" />-->
                <div class="h-[45px] aspect-square border-[1px] border-[#1877F2] solid rounded-full flex-center p-2 cursor-pointer">
<!--                    <img class="h-[23px]" src="/facebook_logo.svg" alt="Facebook Account" />-->
                </div>
            </div>
        </div>

        <div class="text-lg font-bold absolute left-1/2 -translate-x-1/2">
            <a href="/">
                <img class="h-[50px]" :src="logo" alt="AGMAREH logo" loading="eager" decoding="async" />
            </a>
        </div>

        <!-- Mobile Nav Items -->
        <div v-if="toggled.value" class="fixed left-0 top-0 z-40 flex h-[100dvh] overflow-hidden w-full flex-col items-center justify-center gap-24 bg-white text-2xl font-bold">
            <NavLinks :isMobile="true" class="flex flex-col gap-24 text-lg" />
            <div class="absolute bottom-8 right-8 w-[30%] overflow-hidden">
<!--                <img class="w-full rounded-[20px]" src="/art1.png" alt="avi" />-->
            </div>
        </div>

        <!-- Desktop Nav Items -->
        <div class="hidden xl:flex xl:items-center xl:justify-center xl:gap-12 xl:text-lg">
            <NavLinks :isMobile="false" class="flex gap-12" />
        </div>

        <!-- Hamburger Toggle -->
        <div
            @click="toggleNav"
            class="burger z-50 cursor-pointer space-y-1.5 xl:hidden"
        >
            <span :class="['block h-0.5 w-8 bg-black', { 'rotate-45 translate-y-2': toggled.value }]" />
            <span :class="['block h-0.5 w-6 bg-black', { 'w-0': toggled.value }]" />
            <span :class="['block h-0.5 w-4 bg-black', { 'rotate-[-45deg] translate-y-[-2px] w-8': toggled.value }]" />
        </div>
    </nav>
</template>

<script setup lang="ts">
import { ref, watch, defineProps } from 'vue';
import NavLinks from './NavLinks.vue'; // Assuming NavLinks component is in the same directory

const props = defineProps<{
    logo: string;
    name: string;
}>();

const toggled = ref(false);

watch(toggled, (newVal) => {
    document.body.style.overflow = newVal ? 'hidden' : 'auto';
});

const toggleNav = () => {
    toggled.value = !toggled.value;
};
</script>

<style scoped>
/* Add your CSS styles here */
.animated-box {
    /* Your styles */
}

.animate-path {
    animation: pathAnimation 0.75s ease-in-out forwards;
}

@keyframes pathAnimation {
    from {
        stroke-dasharray: 1000;
        stroke-dashoffset: 1000;
    }
    to {
        stroke-dasharray: 1000;
        stroke-dashoffset: 0;
    }
}
</style>
