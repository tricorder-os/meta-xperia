![openembedded](https://www.openembedded.org/images/logo.png "openembedded")

Build instructions to compile openembedded based linux for Sony Xperia XZ1 Compact device.
It requires `lxc` to setup a clean development environment.

The Xperia XZ1 compact is based on the `yoshino` platform and also known as `lilac`.

# development environment

## setup the toolchain

    $ git clone https://github.com/esno/meta-xperia.git
    $ bash ./env.sh <container>

## update the toolchain

    $ bash ./env.sh <container>

## run the build

    $ lxc-attach -n <container> -- /bin/su -l user
    $ cd oe && . ./oe-init-build-env
    $ bitbake <target>

# handling

## hw poweroff / reboot

The Xperia XZ1 compact does **not** boot with the precompiled kernel.
When your device stuck in boot splash (white screen with sony brand) press **volume up** and **power**.
The device vibrates once to notify a reboot. If you want to shutdown the device keep this buttons pressed until
it vibrates three times.

## boot kernel temporarily

    $ fastboot boot <kernel> [<ramdisk> [<seconds>]]

## flash

Turn off your device, hold down the **volume up** and connect the device to your computer.
The notification light should shine **blue** to confirm it's in fastboot mode.

    $ fastboot -s 256M flash boot out/target/product/<device>/boot.img

## oem (factory reset)

download zip archive from sony servers.

    $ fastboot flash oem SW_binaries_for_Xperia_AOSP_<version>_yoshino.img

## cleanup

    $ fastboot erase cache

## reboot

    $ fastboot reboot
