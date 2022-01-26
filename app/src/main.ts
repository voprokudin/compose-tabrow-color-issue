import * as core from '@actions/core'
import sloc from 'node-sloc'

async function run(): Promise<void> {
  try {
    // extract inputs
    const filesAndFoldersToIgnore = JSON.parse(
      core.getInput('filesAndFoldersToIgnore')
    )
    const fileOrFolderToProcess: string = core.getInput('fileOrFolderToProcess')

    // calculate loc stats
    const stats = await sloc({
      path: fileOrFolderToProcess,
      extensions: ['kt'],
      ignorePaths: filesAndFoldersToIgnore,
      ignoreDefault: true
    })

    // set the output of the action
    core.setOutput('locs', stats?.sloc)

    // debug information is only available when enabling debug logging https://docs.github.com/en/actions/managing-workflow-runs/enabling-debug-logging
    core.debug(`LOC ${stats?.sloc?.toString() || ''}`)

  } catch (error) {
    core.setFailed(error.message)
  }
}

run()