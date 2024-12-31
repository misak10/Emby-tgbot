import type { ComponentType, JSX } from 'react'
import { IndexPage } from '@/pages/IndexPage/IndexPage'

interface Route {
  path: string
  Component: ComponentType
  title?: string
  icon?: JSX.Element
}

export const routes: Route[] = [
  { path: '/', Component: IndexPage },
  // { path: '/init-data', Component: InitDataPage, title: 'Init Data' },
  // { path: '/theme-params', Component: ThemeParamsPage, title: 'Theme Params' },
  // { path: '/launch-params', Component: LaunchParamsPage, title: 'Launch Params' },
]
