"""Coronainfo REST-API Interface.

Some text for description to be written here.
"""

from setuptools import setup, find_packages
from pkg_resources import resource_filename


def get_packages():
    """Fetch Necessary Packages From requirements.txt.

    Returns
    -------
    packages : list
        List with required packages
    """
    requirements_file = resource_filename(__name__, "requirements.txt")
    packages = []

    # Open requirements.txt and get packages to install
    with open(requirements_file, mode="r") as packages_file:
        for line in packages_file.readlines():
            if ("#" in line.strip()) and ("Testing" not in line.strip()):
                continue
            elif ("#" in line.strip()) and ("Testing" in line.strip()):
                break
            elif len(line.strip()) == 0:
                continue
            else:
                packages.append(line.strip())
    return packages


metadata = dict(
    name="coronainfo",
    version="0.0.0",
    url='https://github.com/alexstaeding/CoronaInfo/tree/master/API',
    description=__doc__.split("\n")[0],
    long_description=__doc__.split("\n")[1],
    packages=find_packages(),
    zip_safe=False,
    platforms=['Linux', 'Mac OS-X', 'Unix'],
    install_requires=get_packages()
)

if __name__ == '__main__':
    setup(**metadata)
