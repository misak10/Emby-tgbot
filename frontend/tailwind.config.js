/** @type {import('tailwindcss').Config} */
import daisyui from 'daisyui'

export default {
  content: ['./src/pages/**/*.{js,ts,jsx,tsx}', './src/components/**/*.{js,ts,jsx,tsx}'],
  theme: {
    extend: {
      colors: {
        'tg-bg': 'var(--tg-theme-bg-color)',
        'tg-text': 'var(--tg-theme-text-color)',
        'tg-subtitle': 'var(--tg-theme-subtitle-text-color)',
        'tg-hint': 'var(--tg-theme-hint-color)',
        'tg-destructive': 'var(--tg-theme-destructive-text-color)',
        'tg-button': 'var(--tg-theme-button-color)',
        'tg-button-text': 'var(--tg-theme-button-text-color)',
        'tg-separator': 'var(--tg-theme-section-separator-color)',
      },
    },
  },
  plugins: [
    daisyui,
  ],
}
