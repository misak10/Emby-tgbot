import React from 'react'

interface TextSkeletonProps {
  className?: string
}

const TextSkeleton: React.FC<TextSkeletonProps> = ({ className }) => {
  return (
    <div className={className}>
      <div className='flex min-w-full'>
        <div className='flex-1 py-2 pr-20 animate-pulse'>
          <div className='h-2 bg-slate-500 rounded'></div>
        </div>
      </div>
      <div className='flex min-w-full'>
        <div className='flex-1 pr-32 py-2 animate-pulse'>
          <div className='h-2 bg-slate-500 rounded'></div>
        </div>
      </div>
    </div>
  )
}

export default TextSkeleton
